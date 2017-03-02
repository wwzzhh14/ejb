package action;

import bean.ScoreBean;
import bean.UserNumBean;
import factory.EjbFactory;

import blservice.InfoService;
import blservice.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by wzh on 26/12/2016.
 */
public class LoginAction implements ActionService {

    UserService userService = (UserService) EjbFactory.getEJB("ejb:/ejb-layer/UserEJB!blservice.UserService");
    InfoService infoService = (InfoService)EjbFactory.getEJB("ejb:/ejb-layer/InfoEJB!blservice.InfoService");

    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session=request.getSession();
        RequestDispatcher dispatcher;
        String userId=request.getParameter("userId");
        String password=request.getParameter("password");
        boolean loginResult=false;
        if(userId!=null){
            loginResult = userService.checkAccount(userId,password);
        }
        if(loginResult){
            session.setAttribute("userId",userId);
            ScoreBean scoreBean = infoService.getScore(userId);
            if(scoreBean!=null){
                addVisitor(request.getServletContext());
                session.setAttribute("ScoreBean",scoreBean);
                try {
                    dispatcher = request.getRequestDispatcher("/pages/Score.jsp");
                    dispatcher.forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }else {
                dispatcher = request.getRequestDispatcher("/pages/Null.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else {
             dispatcher = request.getRequestDispatcher("/pages/Error.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    synchronized private void addVisitor(ServletContext servletContext){
        UserNumBean bean = (UserNumBean) servletContext.getAttribute("UserNumBean");
        bean.setUser(bean.getUser()+1);
        bean.setVisitor(bean.getVisitor()-1);;
        servletContext.setAttribute("UserNumBean",bean);
    }
}
