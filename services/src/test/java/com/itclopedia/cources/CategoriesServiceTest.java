package com.itclopedia.cources;

import com.itclopedia.cources.models.Categories;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

public class CategoriesServiceTest {
    private CategoriesService categoriesService;
    private CategoriesDAO categoriesDAO;

    @BeforeEach
    public void setup() {
        categoriesDAO = Mockito.mock(CategoriesDAO.class);
        categoriesService = new CategoriesService(categoriesDAO);
    }

    @Test
    public void testCreate() {
        Categories category = new Categories();
        category.setName("Name");
        doNothing().when(categoriesDAO).addCategory(category);
        categoriesService.createCategories(category);
        verify(categoriesDAO, times(1)).addCategory(category);
    }

    @Test
    public void testUpdate() {
        Categories category = new Categories();
        category.setName("Name");
        categoriesService.updateCategories(category);
        verify(categoriesDAO, times(1)).updateCategory(category);
    }

    @Test
    public void testDelete() {
        int id = 2;
        when(categoriesDAO.getCategoriesById(id)).thenReturn(null);
        categoriesService.deleteCategories(id);
        verify(categoriesDAO, times(1)).deleteCategory(id);
        assertNull(categoriesService.getCategoriesById(id));
    }
}
