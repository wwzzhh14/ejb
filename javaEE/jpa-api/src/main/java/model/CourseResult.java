package model;

import java.io.Serializable;

/**
 * Created by wzh on 15/12/2016.
 */

public class CourseResult implements Serializable{
    private int courseId;
    private String name;
    private String teacher;
    private int score;


    public CourseResult() {
    }

    public CourseResult(int courseId, String name, String teacher, int score) {
        this.courseId = courseId;
        this.name = name;
        this.teacher = teacher;
        this.score = score;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
