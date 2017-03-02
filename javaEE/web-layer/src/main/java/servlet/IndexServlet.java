package servlet;

import action.ActionService;
import bean.UserNumBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wzh on 16/12/2016.
 */
public class IndexServlet extends HttpServlet {

    private static final String fileName="/WEB-INF/mapping-config.xml";
    private Map<String,ActionService> actions = new HashMap<String, ActionService>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String realPath=config.getServletContext().getRealPath("");
        final String xmlFile=realPath+fileName;
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            File file=new File(xmlFile);
            Document doc= null;
            doc = builder.parse(file);
            NodeList modeList=doc.getElementsByTagName("mapping");
            int len=modeList.getLength();
            for(int i=0;i<len;i++){
                Element elementAction=(Element)modeList.item(i);
                Node pathNode=elementAction.getElementsByTagName("path").item(0);
                Node classNode=elementAction.getElementsByTagName("url").item(0);
                String path=pathNode.getFirstChild().getNodeValue();
                String name=classNode.getFirstChild().getNodeValue();
                Object object=Class.forName(name).newInstance();
                actions.put(path, (ActionService) object);
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String abc=req.getServletPath();
        ActionService action=actions.get(abc);
        action.execute(req, resp);
    }



}























