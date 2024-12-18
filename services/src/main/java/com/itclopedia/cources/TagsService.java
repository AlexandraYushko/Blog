package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagsService {
    private final TagsDAO tagsDAO;

    @Autowired
    public TagsService(TagsDAO tagsDAO) {
        this.tagsDAO = tagsDAO;
    }

    public void createTags(Tag tag) {
        tagsDAO.addTags(tag);
    }

    public void updateTags(Tag tag) {
        tagsDAO.updateTags(tag);
    }

    public void deleteTags(int tagId) {
        tagsDAO.deleteTags(tagId);
    }

    public Tag getTagById(int tagId) {
        return tagsDAO.getTagById(tagId);
    }
}
