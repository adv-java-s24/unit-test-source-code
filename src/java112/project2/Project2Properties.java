package java112.project2;


import java.io.*;
import java.util.*;

import java112.utilities.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;


/**
 *
 *
 *@author    Eric Knapp
 */
@WebServlet(
name = "project2properties",
urlPatterns = {"/project2-properties"}
) public class Project2Properties extends HttpServlet implements PropertiesLoader {

    private Properties properties;


    public void init() throws ServletException {
        properties = loadProperties("/project2.properties");
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

        PrintWriter out = response.getWriter();

        int row = 0;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>Project 2 Properties</title>");
        out.println("    </head>");
        out.println("<link href=\"/java112/style.css\" rel=\"stylesheet\" type=\"text/css\" />");
        out.println("    <body>");
        out.println("        <h1>Advanced Java - The Last Semester</h1>");
        out.println("        <table>");
        out.println("            <tr class=\"rowh\"><th>Property Name</th><th>Property Value</th></tr>");

        for (Map.Entry entry : properties.entrySet()) {
            row += 1;

            if (row % 2 == 0) {
                out.println("<tr class=\"row1\">");
            } else {
                out.println("<tr class=\"row2\">");
            }


            out.println("<td>");
            out.println(entry.getKey());
            out.println("</td>");

            out.println("<td>");
            out.println(entry.getValue());
            out.println("</td>");

            out.println("</tr>");
        }

        out.println("        </table>");
        out.println("        <p><a href=\"/java112\" class=\"menu_link\">Home</a></p>");
        out.println("    </body>");
        out.println("</html>");
    }
}
