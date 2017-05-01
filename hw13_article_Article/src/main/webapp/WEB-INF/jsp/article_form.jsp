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
        <br>
        <form:label path="titleRu"><s:message code="param.title_ru"/></form:label>
        <form:input path="titleRu"/>
        <form:errors path="titleRu"/>
        <br>
        <form:label path="titleEn"><s:message code="param.title_en"/></form:label>
        <form:input path="titleEn"/>
        <form:errors path="titleEn"/>
        <br>
        <form:label path="textRu"><s:message code="param.text_ru"/></form:label>
        <form:textarea cssClass="text-area col-md-8" rows="25" path="textRu"/>
        <form:errors path="textRu"/>
        <br>
        <form:label path="textEn"><s:message code="param.text_en"/></form:label>
        <form:textarea cssClass="text-area col-md-8" rows="25" path="textEn"/>
        <form:errors path="textEn"/>
        
        <input type="submit" value="<s:message code="param.submit"/>"/>
    </form:form>
        
     <!--<script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> 
    <script type="text/javascript">
        new nicEditor().panelInstance('textRu');
        new nicEditor().panelInstance('textEn');
    </script>-->
</z:mainLayout>
