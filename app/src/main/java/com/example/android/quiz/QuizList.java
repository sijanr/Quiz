package com.example.android.quiz;

/**
 * This class is responsible for creating an object that holds a question, options, and its answer
 */
public class QuizList {


    private String mQuestion;
    private String mOption1;
    private String mOption2;
    private String mOption3;
    private String mOption4;
    private int mCorrectAnswerID;
    private boolean mScoreGiven = false;

    /**
     * A constructor to assign a question, options, and answer value to the class fields
     */
    public QuizList(String Question, String option1, String option2, String option3, String option4, int correctAnswerID) {
        this.mQuestion = Question;
        this.mOption1 = option1;
        this.mOption2 = option2;
        this.mOption3 = option3;
        this.mOption4 = option4;
        this.mCorrectAnswerID = correctAnswerID;
    }

//      getters to get the value of class fields

    public int getAnswerID() {
        return this.mCorrectAnswerID;
    }

    public String getQuestion() {
        return this.mQuestion;
    }

    public String getOption1() {
        return this.mOption1;
    }

    public String getOption2() {
        return this.mOption2;
    }

    public String getOption3() {
        return this.mOption3;
    }

    public String getOption4() {
        return this.mOption4;
    }

    public boolean isScoreGiven() {
        return mScoreGiven;
    }

    public void setScoreGiven(boolean scoreGiven) {
        this.mScoreGiven = scoreGiven;
    }

}

