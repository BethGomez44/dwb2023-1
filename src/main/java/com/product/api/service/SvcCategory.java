package com.product.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.product.api.entity.Category;

@Service
public interface SvcCategory {
	
	List<Category> getCategories();
	Category getCategory(Integer category_id);
	String createCategory(Category category);
	String updateCategory(Integer category_id, Category category);
	String deleteCategory(Integer category_id);
	
}
