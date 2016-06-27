package com.example.vaibhav.testmvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vaibhav on 1/6/16.
 */
public class QuestionModel {

    public static final String TYPE_MULTIPLE_CHOICE = "MultipleChoiceQuestion";
    public static final String TYPE_SINGLE_CHOICE = "SingleChoiceQuestion";

    private long id;

    private String type;

    private float difficulty;

    @SerializedName("category_id")
    private float categoryId;

    private String title;

    private String solution;

    private ArrayList<AnswerModel> answerModels;

    private ArrayList<String> hints;

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public float getDifficulty() {

        return difficulty;
    }

    public void setDifficulty(float difficulty) {

        this.difficulty = difficulty;
    }

    public float getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(float categoryId) {

        this.categoryId = categoryId;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getSolution() {

        return solution;
    }

    public void setSolution(String solution) {

        this.solution = solution;
    }

    public ArrayList<AnswerModel> getAnswerModels() {

        if(answerModels == null) {

            answerModels = new ArrayList<>();
        }

        return answerModels;
    }

    public void setAnswerModels(ArrayList<AnswerModel> answerModels) {

        this.answerModels = answerModels;
    }

    public ArrayList<String> getHints() {

        if(hints == null) {

            hints = new ArrayList<>();
        }

        return hints;
    }

    public void setHints(ArrayList<String> hints) {

        this.hints = hints;
    }
}
