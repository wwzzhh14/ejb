package model;

import java.io.Serializable;

/**
 * Created by wzh on 15/12/2016.
 */
public class ExamResult implements Serializable{
    private String name;
    private String date;
    private String place;
    private int grade;

    public ExamResult() {
    }

    public ExamResult(String name, String date, String place, int grade) {
        this.name = name;
        this.date = date;
        this.place = place;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
