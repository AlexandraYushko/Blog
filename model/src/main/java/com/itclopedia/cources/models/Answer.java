package com.itclopedia.cources.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Answer {
    private int id;
    private int question_id;
    private String answer;
    private boolean correct;
}
