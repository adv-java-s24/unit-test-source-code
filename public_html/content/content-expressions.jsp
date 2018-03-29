<div class="content">
  <h2>
JSP Expressions
  </h2>
  <%-- Start of Content --%>
    <ul>
      <li>Current time: <%= new java.util.Date() %></li>

      <li>Server: <%= application.getServerInfo() %></li>

      <li>Session ID: <%= session.getId() %></li>

      <li>The <code>testParam</code> form parameter:
          <%= request.getParameter("testParam") %></li>
    </ul>

    <p><a href="/java112" class="menu_link">Home</a></p>

  <%-- End of Content  --%>
</div>
