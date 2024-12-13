package com.itclopedia.cources;

import com.itclopedia.cources.models.Tag;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TagsStarter {
    public static void main(String[] args) {
        TagsDAO tagsDAO = new TagsDAO();
        TagsService tagsService = new TagsService(tagsDAO);

        Tag tag = new Tag();
        tag.setId(3);
        tag.setName("Tag");
        tag.setPublicationDate(Timestamp.valueOf(LocalDateTime.now()));
        tagsService.createTags(tag);

        tag.setName("Second Tag");
        tagsService.updateTags(tag);

        int tagId = tag.getId();
        Tag newTag = tagsService.getTagById(tagId);
        System.out.println("Ответ" + newTag);

        int delTag = 4;
        tagsService.deleteTags(delTag);
    }
}
