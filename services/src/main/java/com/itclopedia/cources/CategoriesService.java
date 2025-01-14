package com.itclopedia.cources;


import com.itclopedia.cources.models.Categories;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoriesService {
    private final CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public void createCategories(Categories category) {
        categoriesRepository.save(category);
    }

    public void updateCategories(Categories category) {
        categoriesRepository.save(category);
    }

    public void deleteCategories(int categoryId) {
        categoriesRepository.deleteById(categoryId);
    }

    public Categories getCategoriesById(int categoryId) {
        return categoriesRepository.findById(categoryId).orElse(null);
    }
}
