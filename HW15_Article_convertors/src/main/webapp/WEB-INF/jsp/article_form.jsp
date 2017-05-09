<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="z" %>

<z:mainLayout>
     
    <c:if test="${not empty message}">${message}</c:if>
    <form:form commandName="articleForm" method="POST">
        <form:label path="slug">Slug</form:label>
        <form:input path="slug"/>
        <form:errors path="slug"/>
        
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
        <form:errors path="title"/>
        
        <form:label path="content">Content</form:label>
        <form:textarea path="content"/>
        <form:errors path="content"/>
        
        <form:select path="language">
            <form:option value="NONE" label="--- Select ---"/>
            <c:forEach items="${languages}" var="language">
                <form:option value="${language.getId()}" label="${language.getName()}"/>
            </c:forEach>
        </form:select>
        
        <form:hidden path="id"/>
        
        <form:hidden path="user"/>
        
        <br>
        
        <input type="submit" value="<s:message code="param.submit"/>"/>
    </form:form>
        
<!--     <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> 
    <script type="text/javascript">
        new nicEditor().panelInstance('textRu');
        new nicEditor().panelInstance('textEn');
    </script>-->
</z:mainLayout>
