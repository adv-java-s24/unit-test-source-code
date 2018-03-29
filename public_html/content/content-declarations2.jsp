<%!

    private int accessCount = 1;

    public int getAccessCount() {
        return accessCount++;
    }

%>

<div class="content">
  <h2>
    JSP Declarations 2
  </h2>
  <%-- Start of Content --%>
    <h4>This page has been accessed <%= getAccessCount() %> times.</h4>

    <p><a href="/java112" class="menu_link">Home</a></p>

  <%-- End of Content  --%>
</div>
