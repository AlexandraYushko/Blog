package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TagsServiceTest {
    private TagsService tagsService;
    private TagsDAO tagsDAO;

    @BeforeEach
    public void setup() {
        tagsDAO = Mockito.mock(TagsDAO.class);
        tagsService = new TagsService(tagsDAO);
    }

    @Test
    public void testCreate() {
        Tag tag = new Tag();
        tag.setName("Name");
        doNothing().when(tagsDAO).addTags(tag);
        tagsService.createTags(tag);
        verify(tagsDAO, times(1)).addTags(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testUpdate() {
        Tag tag = new Tag();
        tag.setName("Name");
        doNothing().when(tagsDAO).updateTags(tag);
        tagsService.updateTags(tag);
        verify(tagsDAO, times(1)).updateTags(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testDelete() {
        int id = 3;
        doNothing().when(tagsDAO).deleteTags(id);
        when(tagsDAO.getTagById(id)).thenReturn(null);
        tagsService.deleteTags(id);
        verify(tagsDAO, times(1)).deleteTags(id);
        assertNull(tagsService.getTagById(id));
    }
}
