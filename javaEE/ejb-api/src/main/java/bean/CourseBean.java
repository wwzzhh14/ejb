package bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wzh on 28/12/2016.
 */
public class CourseBean implements Serializable{
    private int courseId;
    private String name;
    private String teacher;
    private int score;
    private List<ExamResult> examResultList;


    public CourseBean() {
    }

    public CourseBean(int courseId, String name, String teacher, int score, List<ExamResult> examResultList) {
        this.courseId = courseId;
        this.name = name;
        this.teacher = teacher;
        this.score = score;
        this.examResultList = examResultList;
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
    public List<ExamResult> getExamResultList() {
        return examResultList;
    }

    public void setExamResultList(List<ExamResult> examResultList) {
        this.examResultList = examResultList;
    }
}
