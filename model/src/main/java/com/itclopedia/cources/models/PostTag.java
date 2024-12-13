package com.itclopedia.cources.models;

import jakarta.persistence.*;

@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "article_id")
    private int articleId;

    @Column(name = "tag_id")
    private int tagId;
}
