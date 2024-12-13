package com.itclopedia.cources;


import com.itclopedia.cources.models.Categories;


public class CategoriesService {
    private final CategoriesDAO categoriesDAO;

    public CategoriesService(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = new CategoriesDAO();
    }

    public void createCategories(Categories category) {
        categoriesDAO.addCategory(category);
    }

    public void updateCategories(Categories category) {
        categoriesDAO.updateCategory(category);
    }

    public void deleteCategories(int categoryId) {
        categoriesDAO.deleteCategory(categoryId);
    }

    public Categories getCategoriesById(int categoryId) {
        return categoriesDAO.getCategoriesById(categoryId);
    }
}
