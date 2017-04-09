<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
        <link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" type="text/css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="${s:mvcUrl('MC#mainPage').build()}">Main</a>
                    </div>
                    <div class="navbar-right">
                    <ul class="nav navbar">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                                <s:message code="param.language"/>
                                <span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                 <c:forEach var="lang" items="${languageList}">
                                     <li><a href="?lang=${lang.getCode()}">${lang.getName()}</a></li>
                                </c:forEach>
                            </ul>    
                        </li>
                    </ul>

                    </div>
                    
                </div>
            </nav>
            <div class="page-header">
                <h1><s:message code="title.form_validation_example"/></h1>
            </div>
            <ul class="list-group">
                <li class="list-group-item"><a href="${s:mvcUrl('JFC#registration').build()}"><s:message code="registration" arguments="JSR303"/></a></li>
                <li class="list-group-item"><a href="${s:mvcUrl('SFC#registration').build()}"><s:message code="registration" arguments="Spring"/></a></li>
            </ul>
        </div>
        <script src="<c:url value="/resources/js/jquery-3.2.0.min.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    </body>
</html>
