package com.itclopedia.cources.models;

import jakarta.persistence.*;

@Entity
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

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
