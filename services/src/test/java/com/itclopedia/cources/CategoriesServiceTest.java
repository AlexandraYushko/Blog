package com.itclopedia.cources;

import com.itclopedia.cources.models.Categories;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CategoriesServiceTest {
    private CategoriesService categoriesService;
    private CategoriesRepository categoriesRepository;

    @BeforeEach
    public void setup() {
        categoriesRepository = Mockito.mock(CategoriesRepository.class);
        categoriesService = new CategoriesService(categoriesRepository);
    }

    @Test
    public void testCreate() {
        Categories category = new Categories();
        category.setName("Name");
        categoriesService.createCategories(category);
        verify(categoriesRepository, times(1)).save(category);
        assertEquals("Name", category.getName());
    }

    @Test
    public void testUpdate() {
        Categories category = new Categories();
        category.setName("Name");
        when(categoriesRepository.existsById(category.getId())).thenReturn(true);
        categoriesService.updateCategories(category);
        verify(categoriesRepository, times(1)).save(category);
        assertEquals("Name", category.getName());
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(categoriesRepository.existsById(id)).thenReturn(null);
        categoriesService.deleteCategories(id);
        verify(categoriesRepository, times(1)).deleteById(id);
    }
}
