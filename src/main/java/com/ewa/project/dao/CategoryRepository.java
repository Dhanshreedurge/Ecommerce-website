package com.ewa.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ewa.project.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findByCategoryId(Long categoryId);
	
}


