<%-- 
    Document   : main
    Created on : Mar 21, 2017, 10:54:51 AM
    Author     : arch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shop</h1>
        <a href="${s:mvcUrl('DC#productForm').build()}">Make order</a>
    </body>
</html>
