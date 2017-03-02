package listener;


import bean.UserNumBean;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;

/**
 * Created by wzh on 14/12/2016.
 */
public class InitListener implements ServletContextListener,HttpSessionListener,ServletRequestListener {

    private ServletContext servletContext=null;


    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext= servletContextEvent.getServletContext();
        servletContext.setAttribute("times",0);
        servletContext.setAttribute("user", 0);
        servletContext.setAttribute("visitor", -2);

    }


    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }



    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session=httpSessionEvent.getSession();
        session.setMaxInactiveInterval(60);
        addVisitor();

    }


    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
            if(httpSessionEvent.getSession().getAttribute("userId")==null){
                removeVisitor();
            }else {
                removeUser();
            }
    }

    synchronized private void removeUser(){
        UserNumBean bean = (UserNumBean) servletContext.getAttribute("UserNumBean");
        bean.setUser(bean.getUser()-1);
        bean.setSum(bean.getSum()-1);
        servletContext.setAttribute("UserNumBean",bean);
    }
    synchronized private void removeVisitor(){
        UserNumBean bean = (UserNumBean) servletContext.getAttribute("UserNumBean");
        bean.setVisitor(bean.getVisitor()-1);
        bean.setSum(bean.getSum()-1);
        servletContext.setAttribute("UserNumBean",bean);
    }
    synchronized private void addVisitor(){
        UserNumBean bean = (UserNumBean) servletContext.getAttribute("UserNumBean");
        if(bean==null){
            bean=new UserNumBean(-2,0,-2);
        }
        bean.setVisitor(bean.getVisitor()+1);
        bean.setSum(bean.getSum()+1);
        servletContext.setAttribute("UserNumBean",bean);
    }

    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }


    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
//        System.out.println("visitor:"+servletContext.getAttribute("visitor"));
//        System.out.println("user:"+servletContext.getAttribute("user"));
    }
}
