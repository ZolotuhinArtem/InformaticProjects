<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@attribute name="title"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" rel="stylesheet">
        <link href="<c:url value="/resources/css/main.css"/>" type="text/css" rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-3.2.0.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <title>
            <c:if test="${not empty title}">${title}</c:if>
        </title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${s:mvcUrl('MC#mainPage').build()}"><s:message code="param.title"/></a>
                    </div>
                    <div class="navbar-right">
                    <ul class="nav navbar">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <s:message code="param.language"/>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="?lang=ru">ru</a></li>
                                <li><a href="?lang=en">en</a></li>
                            </ul>    
                        </li>
                    </ul>

                    </div>
                    
                </div>
            </nav>
            <jsp:doBody/>
        </div>
        
    </body>
</html>
