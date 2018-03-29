<%!

private int accessCount = 1;

%>


<div class="content">
  <h2>
    JSP Declarations
  </h2>
  <%-- Start of Content --%>

    <h3>This page has been accessed <%= accessCount++ %> times.</h3>

    <p><a href="/java112" class="menu_link">Home</a></p>

  <%-- End of Content  --%>
</div>
