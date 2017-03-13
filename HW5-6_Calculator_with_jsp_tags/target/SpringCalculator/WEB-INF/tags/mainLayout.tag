
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%@attribute name="title" %>


<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<c:url value="/resources/css/main-style.css"/>" rel="stylesheet">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
    <title>
        <c:if test="${not empty title}">${title}</c:if>
    </title>
  </head>
  <body>
      <div class="canvas">
          <jsp:doBody/>
      </div>
      <div class="footer">
          <jsp:include page="/WEB-INF/jsp/templates/footer.jsp"/>
      </div>
    
  </body>
</html>