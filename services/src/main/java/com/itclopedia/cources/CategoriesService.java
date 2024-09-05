package com.itclopedia.cources;


import com.itclopedia.cources.models.Categories;

import java.sql.SQLException;

public class CategoriesService {
    private CategoriesDAO categoriesDAO;

    public CategoriesService(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
    }

    public void createCategories(Categories category) {
        try {
            categoriesDAO.addCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCategories(Categories category) {
        try {
            categoriesDAO.updateCategory(category);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCategories(int categoryId) {
        try {
            categoriesDAO.deleteCategory(categoryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
