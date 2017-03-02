package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wzh on 15/01/2017.
 */
@Entity
@Table(name = "tb_course")
public class Course {
    private int courseId;
    private String name;
    private String teacher;

    public Course() {
    }

    public Course(int courseId, String name, String teacher) {
        this.courseId = courseId;
        this.name = name;
        this.teacher = teacher;
    }

    @Id
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
}
