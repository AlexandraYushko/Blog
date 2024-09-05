package com.itclopedia.cources.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Comments {
    private int id;
    private int author_id;
    private int article_id;
    private String text;
}
