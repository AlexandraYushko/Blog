package com.itclopedia.cources.models;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class User {
    private int uuid;
    private String name;
    private String email;
    private String password;
    private Timestamp registration_date;
}
