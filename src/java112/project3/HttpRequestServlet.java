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
name = "project3RequestServlet",
urlPatterns = {"/project3-request"}
) public class HttpRequestServlet extends HttpServlet {

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

        HttpRequestData requestData = new HttpRequestData();

        requestData.setRemoteComputer(request.getRemoteHost());
        requestData.setRemoteComputerAddress(request.getRemoteAddr());
        requestData.setHttpMethod(request.getMethod());
        requestData.setRequestUri(request.getRequestURI());
        requestData.setRequestUrl(request.getRequestURL().toString());
        requestData.setRequestProtocol(request.getProtocol());
        requestData.setServerName(request.getServerName());
        requestData.setServerPort(request.getServerPort());
        requestData.setServerLocale(request.getLocale());
        requestData.setQueryString(request.getQueryString());
        requestData.setQueryParameter(request.getParameter("queryParameter"));
        requestData.setUserAgentHeader(request.getHeader("User-Agent"));

        request.setAttribute("requestData", requestData);

        String url = "/project3-request.jsp";

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}








