package ejbbean;

import model.CourseResult;
import model.ExamResult;
import Factory.JPAFactory;
import bean.CourseBean;
import bean.ScoreBean;
import blservice.InfoService;
import dataservice.CourseDataService;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by wzh on 28/12/2016.
 */
@Stateless(name = "InfoEJB")
public class InfoBean implements InfoService {

    CourseDataService courseDataService= (CourseDataService) JPAFactory.getJPA("");

    public ScoreBean getScore(String id) {
        List<CourseResult> courseList = courseDataService.getCourseByUserId(id);
        List<CourseBean> courseBeenList = new ArrayList<CourseBean>();
        ScoreBean scoreBean = new ScoreBean();
        for(int i=0;i<courseList.size();i++){
            CourseResult c=(CourseResult)courseList.get(i);
            List<ExamResult> examList = courseDataService.getExamByCourseIdAndUserId(id,c.getCourseId());
//            CourseBean courseBean=new CourseBean(c.getCourseId(),c.getName(),c.getTeacher(),c.getScore(),examList);
//            courseBeenList.add(courseBean);
        }
        scoreBean.setCourseList(courseBeenList);
//        ScoreBean scoreBean = new ScoreBean();
        return scoreBean;
    }
}
