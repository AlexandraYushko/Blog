package com.itclopedia.cources.models;

import java.sql.Timestamp;

public class Tags {
    private int id;
    private String name;
    private Timestamp publicationDate;

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }
}
