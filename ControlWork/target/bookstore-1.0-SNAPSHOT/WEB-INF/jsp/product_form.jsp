<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action="${s:mvcUrl('DC#addOrder').build()}">
            <div>
                <input id="email" type="text" placeholder="email">
            </div>
            <div>
                <input id="name" type="text" placeholder="name">
            </div>
            <div>
                <input id="address" type="text" placeholder="address">
            </div>
            
            <c:forEach var="item" items="${list}">
                <div>${item.getName()} - ${item.getPrice} <input id="${item.getName()}_count" type="text" placeholder="count" value="0"></div>
            </c:forEach>
            
            <div>
                <input type="submit" value="Confirm">
            </div>
        </form>
    </body>
    
</html>
