package dataservice;



import model.CourseResult;
import model.ExamResult;

import java.util.List;

/**
 * Created by wzh on 28/12/2016.
 */

@javax.ejb.Remote
public interface CourseDataService {
    public List<CourseResult> getCourseByUserId(String userId);
    public List<ExamResult> getExamByCourseIdAndUserId(String userId, int courseId);
}
