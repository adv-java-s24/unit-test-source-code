package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Eric Knapp
 */
@WebServlet(
name = "lab33Servlet",
urlPatterns = {"/lab33"}
) public class Lab33Servlet extends HttpServlet {

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

        Map map = new HashMap();

        map.put("number", 1);
        map.put("text", "This is some sample text.");
        map.put("html", "<h2>This is an h2</h2>");
        map.put("aDate", new Date());

        request.setAttribute("myMap", map);

        String url = "/lab33.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}
