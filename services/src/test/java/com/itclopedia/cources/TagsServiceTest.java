package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TagsServiceTest {
    private TagsService tagsService;
    private TagsRepository tagsRepository;

    @BeforeEach
    public void setup() {
        tagsRepository = Mockito.mock(TagsRepository.class);
        tagsService = new TagsService(tagsRepository);
    }

    @Test
    public void testCreate() {
        Tag tag = new Tag();
        tag.setName("Name");
        tagsService.createTags(tag);
        verify(tagsRepository, times(1)).save(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testUpdate() {
        Tag tag = new Tag();
        tag.setName("Name");
        when(tagsRepository.existsById(tag.getId())).thenReturn(true);
        tagsService.updateTags(tag);
        verify(tagsRepository, times(1)).save(tag);
        assertEquals("Name", tag.getName());
    }

    @Test
    public void testDelete() {
        int id = 3;
        when(tagsRepository.existsById(id)).thenReturn(null);
        tagsService.deleteTags(id);
        verify(tagsRepository, times(1)).deleteById(id);
    }
}
