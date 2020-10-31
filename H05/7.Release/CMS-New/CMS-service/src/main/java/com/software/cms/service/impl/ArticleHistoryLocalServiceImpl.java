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

package com.software.cms.service.impl;

import com.liferay.portal.aop.AopService;
import com.software.cms.model.ArticleHistory;
import com.software.cms.model.impl.ArticleHistoryImpl;
import com.software.cms.service.base.ArticleHistoryLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the article history local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.software.cms.service.ArticleHistoryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author DungNV
 * @see ArticleHistoryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.software.cms.model.ArticleHistory",
	service = AopService.class
)
public class ArticleHistoryLocalServiceImpl
	extends ArticleHistoryLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.software.cms.service.ArticleHistoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.software.cms.service.ArticleHistoryLocalServiceUtil</code>.
	 */
	public List<ArticleHistory> getHistoryFromArticle(long articleId) {
		List<ArticleHistory> list = new ArrayList<ArticleHistory>();
		try {
			list.addAll(articleHistoryPersistence.findByArticle(articleId));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	public ArticleHistory create(){
		return new ArticleHistoryImpl();
	}
}