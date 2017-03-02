package bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wzh on 26/12/2016.
 */
public class ScoreBean implements Serializable {
    private List<CourseBean> courseList;

    public ScoreBean() {
    }

    public ScoreBean(List<CourseBean> courseList) {
        this.courseList = courseList;
    }

    public List<CourseBean> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<CourseBean> courseList) {
        this.courseList = courseList;
    }
}
