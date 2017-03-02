package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wzh on 15/01/2017.
 */
@Entity
@Table(name = "tb_selection")
public class Selection {
    private String userId;
    private int courseId;
    private int score;

    public Selection() {
    }

    public Selection(String userId, int courseId, int score) {
        this.userId = userId;
        this.courseId = courseId;
        this.score = score;
    }

    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
