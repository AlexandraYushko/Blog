package com.itclopedia.cources.models;

public class Answer {
    private int id;
    private int questionId;
    private String answer;
    private boolean correct;

    public Answer(int id, int questionId, String answer, boolean correct) {
        this.id = id;
        this.questionId = questionId;
        this.answer = answer;
        this.correct = correct;
    }

    public int getId() {
        return id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
}
