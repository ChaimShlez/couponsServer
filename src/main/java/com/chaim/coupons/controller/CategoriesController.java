package com.chaim.coupons.controller;

import com.chaim.coupons.dto.CategoryDto;
import com.chaim.coupons.entitys.CategoryEntity;
import com.chaim.coupons.exceptions.ServerException;
import com.chaim.coupons.logic.CategoriesLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoriesController {
    private CategoriesLogic categoriesLogic;

    @Autowired
    public CategoriesController(CategoriesLogic categoriesLogic) {
        this.categoriesLogic = categoriesLogic;
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryEntity category) throws ServerException {
        this.categoriesLogic.addCategory(category);
    }

    @PutMapping
    public void updateCategory(@RequestBody CategoryEntity category) throws ServerException {
        this.categoriesLogic.update(category);
    }

    @DeleteMapping("{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") long id) throws ServerException {
        this.categoriesLogic.remove(id);

    }

    @GetMapping("{categoryId}")
    public CategoryDto getCategory(@PathVariable("categoryId") long id) throws ServerException {
        CategoryDto category = this.categoriesLogic.getCategory(id);
        return category;

    }

    @GetMapping()
    public List<CategoryDto> getCategories() throws ServerException {
        List<CategoryDto> categories = this.categoriesLogic.getCategories();
        return categories;

    }
}
