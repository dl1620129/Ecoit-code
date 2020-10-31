/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.web.ecoit.portal.quangcao.service.impl;

import com.liferay.portal.aop.AopService;
import com.web.ecoit.portal.quangcao.model.QuangCaoSlider;
import com.web.ecoit.portal.quangcao.service.base.QuangCaoSliderLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the quang cao slider local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.web.ecoit.portal.quangcao.service.QuangCaoSliderLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoSliderLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.web.ecoit.portal.quangcao.model.QuangCaoSlider",
	service = AopService.class
)
public class QuangCaoSliderLocalServiceImpl
	extends QuangCaoSliderLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.web.ecoit.portal.quangcao.service.QuangCaoSliderLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.web.ecoit.portal.quangcao.service.QuangCaoSliderLocalServiceUtil</code>.
	 */
	public QuangCaoSlider findBybyQuangCaoSliderIdAndGroupId(long quangCaoSliderId, long groupId) {
		try {
			return this.quangCaoSliderPersistence.findBybyQuangCaoSliderIdAndGroupId(quangCaoSliderId, groupId);
		} catch (Exception e) {
			return null;
		}
	}
	public List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId){
		try {
			return this.quangCaoSliderPersistence.findBybyQuangCaoIdAndGroupId(quangCaoId, groupId);
		} catch (Exception e) {
			return null;
		}
	}
}