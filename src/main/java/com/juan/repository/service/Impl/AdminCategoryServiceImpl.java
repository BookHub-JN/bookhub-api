package com.juan.repository.service.Impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juan.model.entity.Category;
import com.juan.repository.CategoryRepository;
import com.juan.repository.service.AdminCategoryService;

@Service
public class AdminCategoryServiceImpl implements AdminCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Category> paginate(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Transactional
    @Override
    public Category create(Category category) {
        category.setCreatedAt(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    @Transactional(readOnly = true)
    @Override
    public Category finById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
    }

    @Transactional
    @Override
    public Category update(Integer id, Category updateCategory) {
        Category categoryFromDB = finById(id);

        categoryFromDB.setName(updateCategory.getName());
        categoryFromDB.setDescription(updateCategory.getDescription());
        categoryFromDB.setUpdatedAt(LocalDateTime.now());

        return categoryRepository.save(categoryFromDB);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Category categoryFromDB = finById(id);
        categoryRepository.delete(categoryFromDB);
    }

}
