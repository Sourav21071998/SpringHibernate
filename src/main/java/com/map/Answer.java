package com.map;

import javax.persistence.*;

@Entity
public class Answer
{

    @Id
    @Column(name = "Answer_Id")
    private int answerId;


    private String answer;

   @ManyToOne
   private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
    }



    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }




    public Answer(int answerId,String answer, Question question) {
        this.answerId = answerId;
        this.answer= answer;
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


}
