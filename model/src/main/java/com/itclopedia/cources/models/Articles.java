package com.itclopedia.cources.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
public class Articles {
    private int id;
    private String title;
    private String content;
    private int author_id;
    private int category_id;
    private boolean premium;
    private Timestamp publication_time;
}
