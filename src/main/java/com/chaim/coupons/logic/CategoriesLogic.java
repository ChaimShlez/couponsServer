package com.chaim.coupons.logic;

import com.chaim.coupons.dal.ICategoryDal;
import com.chaim.coupons.dto.CategoryDto;
import com.chaim.coupons.entitys.CategoryEntity;
import com.chaim.coupons.enums.ErrorTypes;
import com.chaim.coupons.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller

public class CategoriesLogic {
    private ICategoryDal categoryDal;

    @Autowired
    public CategoriesLogic(ICategoryDal categoryDal) {
        this.categoryDal = categoryDal;
    }


    public void addCategory(CategoryEntity category) throws ServerException {
        validateCategory(category);
        try {
            categoryDal.save(category);
        } catch (Exception e) {
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Failed to create category " + category.toString(), e );
        }


        // return null;
    }


    public void remove(long id) throws ServerException {
        try {
            categoryDal.deleteById(id);
        } catch (Exception e) {
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Failed to remove category " + id, e);
        }


    }

    public CategoryDto getCategory(long id) throws ServerException {
        CategoryDto category;
        try {
            category = categoryDal.findById(id);
        } catch (Exception e) {
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Error in getCategoryId = " + id, e );
        }
        return category;
    }

    public List<CategoryDto> getCategories() throws ServerException {
        List<CategoryDto> category;
        try {
            category = categoryDal.findCategories();
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR, "Error in getCategories = " , e );
        }
        return category;
    }

    public void update(CategoryEntity category) throws ServerException {
        validateCategory(category);
        try{
            categoryDal.save(category);
        }catch (Exception e){
            throw new ServerException(ErrorTypes.GENERAL_ERROR,"Failed to update category " + category.getId(), e );
        }


    }

    private void validateCategory(CategoryEntity category) throws ServerException {
        validateCategoryName(category.getName());

    }

    private void validateCategoryName(String name) throws ServerException {
        if (name.isBlank()) {
            throw new ServerException(ErrorTypes.CATEGORY_NAME_IS_NULL, name);
        }
        if (name.length() < 3) {
            throw new ServerException(ErrorTypes.INVALID_CATEGORY_NAME, "the category invalid " + name);
        }


    }
}
