package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TagsService {
    private final TagsRepository tagsRepository;

    @Autowired
    public TagsService(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    public void createTags(Tag tag) {
        tagsRepository.save(tag);
    }

    public void updateTags(Tag tag) {
        tagsRepository.save(tag);
    }

    public void deleteTags(int tagId) {
        tagsRepository.deleteById(tagId);
    }

    public Tag getTagById(int tagId) {
        return tagsRepository.findById(tagId).orElse(null);
    }
}
