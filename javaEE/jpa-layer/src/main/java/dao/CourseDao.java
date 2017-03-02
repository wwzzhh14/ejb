package dao;



import model.CourseResult;
import model.ExamResult;
import dataservice.CourseDataService;

import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by wzh on 15/12/2016.
 */

@Stateless(name = "CourseDao")
public class CourseDao implements CourseDataService {
    BaseDao baseDao=new BaseDao();
    public List<CourseResult> getCourseByUserId(String userId){
        String sql="select tc.courseId as courseId,tc.name as name,tc.teacher as teacher,ts.score as score from Course tc,Selection ts where ts.userId = ? and ts.courseId = tc.courseId";
        return baseDao.getModelBySql(sql,new CourseResult());
    }

    public List<ExamResult> getExamByCourseIdAndUserId(String userId, int courseId){
        String sql="select te.name as name,te.date as date,te.place as place,ts.grade as grade from Exam te,Score ts where te.courseId=? and te.examId=ts.examId and ts.userId=? ";
        return baseDao.getModelBySql(sql,new ExamResult());
    }

}
