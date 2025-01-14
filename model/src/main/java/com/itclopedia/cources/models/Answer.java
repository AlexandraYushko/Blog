package com.itclopedia.cources.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "question_id")
    private int questionId;

    @Column(name = "answer")
    private String answer;

    @Column(name = "is_correct")
    private boolean correct;
}
