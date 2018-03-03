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
        out.print("        <h1>First 112 Servlet</h1>");
        out.print("    </body>");
        out.print("</html>");
        out.close();
    }
}
