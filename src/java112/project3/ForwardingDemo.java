package java112.project3;


import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *  This class demonstrates Forwarding an HTTP Request
 *
 *@author    eknapp
 */
@WebServlet(
name = "forwardDemo",
urlPatterns = {"/forward-demo"}
) public class ForwardingDemo extends HttpServlet {

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
    public void doGet(HttpServletRequest request,
    HttpServletResponse response)
    throws ServletException, IOException {

        // Create the url
        String url = "/transferDemo.jsp";

        //request.setAttribute("pageTitle", "First MVC Demo");

        // Forward to jsp page
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

