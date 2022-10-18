package com.product.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Category;
import com.product.api.repository.RepoCategory;

@Service
public class SvcCategoryImp implements SvcCategory {
	
	@Autowired
	RepoCategory repo;
	
	@Override
	public List<Category> getCategories() {
		return repo.findByStatus(1);
	}

	@Override
	public Category getCategory(Integer category_id) {
		return repo.findByCategoryId(category_id);
	}

	@Override
	public String createCategory(Category category) {
		Category categorySaved = (Category) repo.findByCategory(category.getCategoryName());
		if(categorySaved != null) {
			if(categorySaved.getCategoryStatus() == 0) {
				repo.activateCategory(categorySaved.getCategoryID());
				return "category has been activated";
			}
			else {
				return "category already exists";
			}
		}
		repo.createCategory(category.getCategoryName());
		return "category created";
	}

	@Override
	public String updateCategory(Integer category_id, Category category) {
		Category categorySaved = (Category) repo.findByCategoryId(category_id);
		if(categorySaved == null) {
			return "category does not exist";
		} else {
			if(categorySaved.getCategoryStatus() == 0) {
				return "category is not active";
			}
			else {
				categorySaved = (Category) repo.findByCategory(category.getCategoryName());
				if(categorySaved != null) {
					return "category already exists";
				}
				repo.updateCategory(category_id, category.getCategoryName());
				return "category updated";
			}
		}
	}

	@Override
	public String deleteCategory(Integer category_id) {
		Category categorySaved = (Category) repo.findByCategoryId(category_id);
		if(categorySaved == null) {
			return "category does not exist";
		} else {
			repo.deleteById(category_id);
			return "category removed";
		}
	}

}
