package com.itclopedia.cources;


import com.itclopedia.cources.models.Categories;

public class CategoriesStarter {
    public static void main(String[] args) {
        CategoriesDAO categoriesDAO = new CategoriesDAO();
        CategoriesService categoriesService = new CategoriesService(categoriesDAO);

        Categories category = new Categories();
        category.setId(1);
        category.setName("Category");
        categoriesService.createCategories(category);

        category.setName("New name category");
        categoriesService.updateCategories(category);

        int categoryId = category.getId();
        Categories newCategory = categoriesService.getCategoriesById(categoryId);
        System.out.println("Категория " + newCategory);

        int delCategory = 2;
        categoriesService.deleteCategories(delCategory);
    }
}
