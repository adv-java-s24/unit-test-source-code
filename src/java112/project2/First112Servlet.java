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

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <title>Advanced Java</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>Advanced Java - The Last Semester</h1>");
        out.print("        <h2>First 112 Servlet</h2>");
        out.print("        <h3>Eric Knapp</h3>");
        out.print("        <p><img src=\"/java112/images/bomb-sculptures.jpg\" width=\"800\"></p>");
        out.print("        <p><a href=\"/java112\">Home</a></p>");
        out.print("    </body>");
        out.print("</html>");
    }
}
