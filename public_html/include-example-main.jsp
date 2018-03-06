<!DOCTYPE html>

<html>
  <head>
    <meta name="generator" content="HTML Tidy, see www.w3.org">

    <title>Include Example Main Page</title>
  </head>

  <body>
  <h1>Include Example Main Page</h1>

  <p>This content is from the main page.</p>


  <%--
    The following line will insert the contents of the file
    before translation.
  --%>
  <%@ include file="include-example-included.jsp"%>

  <p><a href="/java112">Home</a></p>
  </body>
</html>
