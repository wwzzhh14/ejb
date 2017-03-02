package handler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by wzh on 29/12/2016.
 */
public class UserStateHandler extends BodyTagSupport {

    @Override
    public int doEndTag() throws JspException {
        PageContext pageContext =  super.pageContext;
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
        HttpSession session = request.getSession();
        String url = request.getServletPath();
        System.out.println(session.getAttribute("userId"));
        System.out.println(url);
        if(session.getAttribute("userId")!=null){
            if(!url.equals("/pages/Score.jsp")){
                try {
                    response.sendRedirect("/pages/Score.jsp");
                    return SKIP_BODY;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }else {
            if (!url.equals("/pages/Login.jsp")){
                try {
                    response.sendRedirect("/");
                    return SKIP_BODY;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return EVAL_PAGE;
    }

}
