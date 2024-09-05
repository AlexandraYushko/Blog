package com.itclopedia.cources;

import com.itclopedia.cources.models.Tags;

public class TagsService {
    private TagsDAO tagsDAO;

    public TagsService(TagsDAO tagsDAO) {
        this.tagsDAO = tagsDAO;
    }

    public void createTags(Tags tag) {
        tagsDAO.addTags(tag);
    }

    public void updateTags(Tags tag) {
        tagsDAO.updateTags(tag);
    }

    public void deleteTags(int tagId) {
        tagsDAO.deleteTags(tagId);
    }
}
