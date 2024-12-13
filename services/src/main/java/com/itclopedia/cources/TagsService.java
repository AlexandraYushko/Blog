package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;

public class TagsService {
    private final TagsDAO tagsDAO;

    public TagsService(TagsDAO tagsDAO) {
        this.tagsDAO = new TagsDAO();
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
