package com.juan.repository.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.juan.model.entity.Category;


public interface AdminCategoryService {
    List<Category> getAll();

    Page<Category> paginate(Pageable pageable);

    Category create(Category category);

    Category finById(Integer id);

    Category update(Integer id, Category category);

    void delete(Integer id);
}
