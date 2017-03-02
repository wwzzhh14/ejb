package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wzh on 15/01/2017.
 */
@Entity
@Table(name = "tb_score")
public class Score {
    private String userId;
    private int examId;
    private int grade;

    public Score() {
    }

    public Score(String userId, int examId, int grade) {
        this.userId = userId;
        this.examId = examId;
        this.grade = grade;
    }

    @Id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
