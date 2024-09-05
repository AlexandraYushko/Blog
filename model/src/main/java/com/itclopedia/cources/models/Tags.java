package com.itclopedia.cources.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Tags {
    private int id;
    private String name;
    private Timestamp publication_date;
}
