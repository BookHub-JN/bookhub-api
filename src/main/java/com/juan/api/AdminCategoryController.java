package com.juan.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juan.model.entity.Category;
import com.juan.repository.service.AdminCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/categories")
public class AdminCategoryController {

    private final AdminCategoryService adminCategoryService;

    // public AdminCategoryController(AdminCategoryService adminCategoryService) {
    //     this.adminCategoryService = adminCategoryService;
    // }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories = adminCategoryService.getAll();
        return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<Category>> paginateCategories(
            @PageableDefault(size = 5, sort = "name") Pageable pageable) {
        Page<Category> categories = adminCategoryService.paginate(pageable);
        return new ResponseEntity<Page<Category>>(categories, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category newCategory = adminCategoryService.create(category);
        return new ResponseEntity<Category>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Integer id) {
        Category category = adminCategoryService.finById(id);
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Integer id, @RequestBody Category category) {
        Category updatedCategory = adminCategoryService.update(id, category);
        return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Integer id) {
        adminCategoryService.delete(id);
        return new ResponseEntity<Category>(HttpStatus.NO_CONTENT);
    }

}
