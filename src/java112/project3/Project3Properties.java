package java112.project3;

import java.io.*;
import java.util.*;

import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 *
 *
 *@author    Eric Knapp
 */
@WebServlet(
    name = "project3Properties",
    urlPatterns = { "/project3-properties" }
)

public class Project3Properties extends HttpServlet implements PropertiesLoader {

    private Properties properties;

    public void init() throws ServletException {
        properties = loadProperties("/project3.properties");
    }

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

        request.setAttribute("project3Properties", properties);

        String url = "/project3-properties.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}





