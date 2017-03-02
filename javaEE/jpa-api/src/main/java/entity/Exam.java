package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wzh on 15/01/2017.
 */
@Entity
@Table(name = "tb_exam")
public class Exam {

    private int examId;
    private String name;
    private String date;
    private String place;
    private int courseId;

    public Exam() {
    }

    public Exam(int examId, String name, String date, String place, int courseId) {
        this.examId = examId;
        this.name = name;
        this.date = date;
        this.place = place;
        this.courseId = courseId;
    }

    @Id
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
