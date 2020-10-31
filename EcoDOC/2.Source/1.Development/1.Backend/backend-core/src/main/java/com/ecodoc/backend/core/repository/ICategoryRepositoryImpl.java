package com.ecodoc.backend.core.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecodoc.backend.core.domain.Category;

@Repository
@Transactional(readOnly = false)
public class ICategoryRepositoryImpl implements ICategoryRepositoryCustom {
	@PersistenceContext
    EntityManager entityManager;
	
	@Override
	public void updateOrdersAfterCurrentOrder(Integer orderNumber, Long categoryId, Long categoryTypeId) {
		 List<Category> listCategory = this.getNeedUpdateList(orderNumber, categoryId, categoryTypeId);
		 this.updateOrders(listCategory, orderNumber);
	}
	
//	methods use only in this class
	private void updateOrders(List<Category> categoryList, Integer currentOrderNumber) {
		
		if (categoryList.size() == 0) {
			return;
		}
		
		String sqlQueryString = this.getUpdateOrdersString(categoryList,currentOrderNumber);
		
		
		Query query = entityManager.createNativeQuery(sqlQueryString);

		query.executeUpdate();
	}
	
	private List<Category> getNeedUpdateList(Integer orderNumber, Long categoryId, Long categoryTypeId) {
		Query query = entityManager.createNativeQuery(
				  "SELECT *"
				+ " FROM ecodoc.sys_category"
				+ " WHERE category_type_id = ?"
				+ " AND id != ?"
				+ " AND (order_number >= ? OR order_number IS NULL)"
				+ " ORDER BY order_number", Category.class);
		query.setParameter(1, categoryTypeId);
		query.setParameter(2, categoryId);
		query.setParameter(3, orderNumber);
		List<Category> listCategory = query.getResultList();
		
		return listCategory;
	}
	
	private String getUpdateOrdersString(List<Category> categoryList, Integer currentOrderNumber) {
		currentOrderNumber += 1;
		
		String sqlQueryString = "UPDATE ecodoc.sys_category" + 
				                " SET order_number = CASE id ";
		String queryConditionString = " WHERE id IN("; 
		for (Category category : categoryList) {
			sqlQueryString += " WHEN " + category.getId() + " THEN " + currentOrderNumber;
			queryConditionString += "" + category.getId() + ",";
			currentOrderNumber += 1;
		}
		sqlQueryString += " END";
		queryConditionString = queryConditionString
								.substring(0, queryConditionString.length() - 1)
								+ "); ";
		sqlQueryString += queryConditionString;
		
		return sqlQueryString;
	}
}
