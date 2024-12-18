package com.itclopedia.cources;


import com.itclopedia.cources.models.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
    private final CategoriesDAO categoriesDAO;

    @Autowired
    public CategoriesService(CategoriesDAO categoriesDAO) {
        this.categoriesDAO = categoriesDAO;
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
