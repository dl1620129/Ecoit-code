package cms.article.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerException;
import com.liferay.portal.kernel.scheduler.StorageType;
import com.liferay.portal.kernel.scheduler.StorageTypeAware;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.software.cms.model.Article;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.util.NewsWorkflowConstants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"cron.expression=0 0/1 1/1 1/1 * ? *" }, service = ArticleAutoTimePublic.class)
public class ArticleAutoTimePublic extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {
		_log.info("Scheduled task executed...");
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dt = new Date();
		/*
		 * System.out.println("Cron running......" + (dt.getYear() + 1900) + "-" +
		 * (dt.getMonth() + 1) + "-" + dt.getDate() + " " + dt.getHours() + ":" +
		 * dt.getMinutes() + ":" + dt.getSeconds());
		 */
		

		List<Integer> status = new ArrayList<>();
		status.add(10);
		status.add(5);
		status.add(6);
		status.add(1);
		String statusScheduler = StringUtils.join(status, ",");

		List<Article> article = ArticleLocalServiceUtil.getArticleScheduler(sdf.format(dt), statusScheduler);
		if (article != null && article.size() > 0) {
			for (Article art : article) {
				art.setStatus(NewsWorkflowConstants.STATUS_PUBLISH);
				art.setPublishedByUser(art.getCreatedByUser());
				try {
					ArticleLocalServiceUtil.updateArticle(art);
				} catch (SystemException e) {
					System.out.println("error: " + e.toString());
					// e.printStackTrace();
				}
			}
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) throws SchedulerException {

		// extract the cron expression from the properties
		String cronExpression = GetterUtil.getString(properties.get("cron.expression"), _DEFAULT_CRON_EXPRESSION);

		// create a new trigger definition for the job.
		String listenerClass = getClass().getName();
		Trigger jobTrigger = _triggerFactory.createTrigger(listenerClass, listenerClass, new Date(), null,
				cronExpression);

		// wrap the current scheduler entry in our new wrapper.
		// use the persisted storaget type and set the wrapper back to the class field.
		_schedulerEntryImpl = new SchedulerEntryImpl(getClass().getName(), jobTrigger);
		// _schedulerEntryImpl = new
		// StorageTypeAwareSchedulerEntryImpl(_schedulerEntryImpl,
		// StorageType.PERSISTED);

		// update the trigger for the scheduled job.
		_schedulerEntryImpl.setTrigger(jobTrigger);

		// if we were initialized (i.e. if this is called due to CA modification)
		if (_initialized) {
			// first deactivate the current job before we schedule.
			deactivate();
		}

		// register the scheduled task
		_schedulerEngineHelper.register(this, _schedulerEntryImpl, DestinationNames.SCHEDULER_DISPATCH);

		// set the initialized flag.
		_initialized = true;
	}

	@Deactivate
	protected void deactivate() {
		// if we previously were initialized
		if (_initialized) {
			// unschedule the job so it is cleaned up
			try {
				_schedulerEngineHelper.unschedule(_schedulerEntryImpl, getStorageType());
			} catch (SchedulerException se) {
				if (_log.isWarnEnabled()) {
					_log.warn("Unable to unschedule trigger", se);
				}
			}

			// unregister this listener
			_schedulerEngineHelper.unregister(this);
		}

		// clear the initialized flag
		_initialized = false;
	}

	protected StorageType getStorageType() {
		if (_schedulerEntryImpl instanceof StorageTypeAware) {
			return ((StorageTypeAware) _schedulerEntryImpl).getStorageType();
		}

		return StorageType.MEMORY_CLUSTERED;
	}

	@Reference(target = ModuleServiceLifecycle.PORTAL_INITIALIZED, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(SchedulerEngineHelper schedulerEngineHelper) {
		_schedulerEngineHelper = schedulerEngineHelper;
	}

	private static final String _DEFAULT_CRON_EXPRESSION = "0 0/1 1/1 1/1 * ? *";
	private static final Log _log = LogFactoryUtil.getLog(ArticleAutoTimePublic.class);
	private volatile boolean _initialized;
	private TriggerFactory _triggerFactory;
	private SchedulerEngineHelper _schedulerEngineHelper;
	private SchedulerEntryImpl _schedulerEntryImpl = null;
}
