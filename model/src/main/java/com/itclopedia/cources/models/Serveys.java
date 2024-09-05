package com.itclopedia.cources.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Serveys {
    private int id;
    private String type;
    private String question;
    private Timestamp publication_date;
}
