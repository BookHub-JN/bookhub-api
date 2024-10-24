package com.juan.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.juan.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
