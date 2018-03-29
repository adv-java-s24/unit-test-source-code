package java112.project2;


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
name = "first112servlet",
urlPatterns = {"/first112servlet"}
) public class First112Servlet extends HttpServlet {

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

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Advanced Java</title>");
        out.println("    </head>");
        out.println("<link href=\"/java112/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println("    <body>");
        out.println("        <h1>Advanced Java - The Last Semester</h1>");
        out.println("        <h2>First 112 Servlet</h2>");
        out.println("        <h3>Eric Knapp</h3>");
        out.println("        <p><img src=\"/java112/images/bomb-sculptures.jpg\" width=\"800\"></p>");
        out.println("        <p><a href=\"/java112\" class=\"menu_link\">Home</a></p>");
        out.println("    </body>");
        out.println("</html>");
    }
}
