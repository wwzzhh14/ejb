package action;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wzh on 24/12/2016.
 */
public interface ActionService {
    public void execute(HttpServletRequest request, HttpServletResponse response);
}
