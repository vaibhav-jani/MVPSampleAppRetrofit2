package com.example.vaibhav.testmvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by vaibhav on 1/6/16.
 */
public class AssessmentModel {

    private long id;

    private ArrayList<QuestionModel> questionModels;

    @SerializedName("time_allowed")
    private long timeAllowed;

    @SerializedName("can_jump_sections")
    private boolean canJumpSections;

    @SerializedName("questions_mandatory")
    private int questionsMandatory;

    @SerializedName("questions_pool")
    private int questionsPool;

    private String subject;

    @SerializedName("available_starting")
    private String availableStarting;

    @SerializedName("available_until")
    private String availableUntil;

    private boolean shuffled;

    private boolean paid;

    @SerializedName("nav_enabled")
    private boolean navEnabled;

    @SerializedName("nav_visible")
    private boolean navVisible;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimeAllowed() {
        return timeAllowed;
    }

    public void setTimeAllowed(long timeAllowed) {
        this.timeAllowed = timeAllowed;
    }

    public boolean isCanJumpSections() {
        return canJumpSections;
    }

    public void setCanJumpSections(boolean canJumpSections) {
        this.canJumpSections = canJumpSections;
    }

    public int getQuestionsMandatory() {
        return questionsMandatory;
    }

    public void setQuestionsMandatory(int questionsMandatory) {
        this.questionsMandatory = questionsMandatory;
    }

    public int getQuestionsPool() {
        return questionsPool;
    }

    public void setQuestionsPool(int questionsPool) {
        this.questionsPool = questionsPool;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAvailableStarting() {
        return availableStarting;
    }

    public void setAvailableStarting(String availableStarting) {
        this.availableStarting = availableStarting;
    }

    public String getAvailableUntil() {
        return availableUntil;
    }

    public void setAvailableUntil(String availableUntil) {
        this.availableUntil = availableUntil;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public boolean isNavEnabled() {
        return navEnabled;
    }

    public void setNavEnabled(boolean navEnabled) {
        this.navEnabled = navEnabled;
    }

    public boolean isNavVisible() {
        return navVisible;
    }

    public void setNavVisible(boolean navVisible) {
        this.navVisible = navVisible;
    }

    public ArrayList<QuestionModel> getQuestionModels() {

        if(questionModels == null) {

            questionModels = new ArrayList<>();
        }

        return questionModels;
    }

    public void setQuestionModels(ArrayList<QuestionModel> questionModels) {
        this.questionModels = questionModels;
    }
}
