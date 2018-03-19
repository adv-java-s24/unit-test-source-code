package java112.project3;
 
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
 
/**
 *  
 *
 *@author    Eric Knapp
 */
@WebServlet(
    name = "beans", 
    urlPatterns = { "/beans-demo" }
)
 
public class BeanDemo extends HttpServlet {
 
    /**
     *  Handles HTTP GET requests.
     *
     *@param  request               the HttpRequest
     *@param  response              the HttpResponse
     *@exception  ServletException  if there is a general 
     *                              servlet exception
     *@exception  IOException       if there is a general 
     *                              I/O exception
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
 
         BeanOne bean = new BeanOne();
         bean.setData("Hello");
         
         request.setAttribute("myCoolBean", bean);
         
         request.setAttribute("pageTitle", "Bean Demo");
         
         String url = "/beanOneDemoFullPage.jsp";
         
         RequestDispatcher dispatcher 
                = getServletContext().getRequestDispatcher(url);
         dispatcher.forward(request, response);
    }
 
}





