package com.itclopedia.cources.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "author_id")
    private int authorId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "premium")
    private boolean premium;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp publicationTime;
}
