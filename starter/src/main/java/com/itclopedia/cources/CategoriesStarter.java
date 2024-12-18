package com.itclopedia.cources;


import com.itclopedia.cources.models.Categories;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoriesStarter {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CategoriesService categoriesService = context.getBean(CategoriesService.class);

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

        context.close();
    }
}
