package com.map;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question
{
    @Id
    @Column(name = "Question_Id")
    private int questionId;

    private String question;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<Answer> answers;

    public Question() {
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Question(int questionId, String question, List<Answer> answers)
    {
        this.questionId = questionId;
        this.question = question;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }




}
