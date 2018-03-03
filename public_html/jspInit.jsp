<!DOCTYPE html>

<%!

    private int accessCount = 1;

    public int getAccessCount() {
        return accessCount++;
    }

    public void jspInit() {
        accessCount = 1000;
    }

%>

<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org" />

    <title>JSP Declarations</title>
  </head>

  <body>
    <h3>JSP Declarations</h3>

    <h4>This page has been accessed <%= getAccessCount() %> times.</h4>

    <p><a href="/java112">Home</a></p>
  </body>
</html>
