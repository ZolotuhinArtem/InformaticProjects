<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="z" %>
<z:mainLayout>
    <h1><c:if test="${not empty errorPageMessage}">${errorPageMessage}</c:if></h1>
</z:mainLayout>
