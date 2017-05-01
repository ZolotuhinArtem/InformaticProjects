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
        <form:hidden path="id"/>
        <c:forEach items="${articleForm.texts}" var="text" varStatus="i">
            <div>
                <h3>Locale: ${text.getLanguage()}</h3>
                <div class="form-group">
                    <input lass="form-control" name="texts[${i.index}].head" value="${text.getHead()}" placeholder="Title"/>
                </div>
                <div class="form-group">
                    <textarea class="form-control" rows="5" name="texts[${i.index}].body">${text.getBody()}</textarea>
                </div>
                <input name="texts[${i.index}].language" value="${text.getLanguage()}" type="hidden"/>
                <input name="texts[${i.index}].id" value="${text.getId()}" type="hidden"/>
            </div>
	</c:forEach>
        <br>
        
        
        <input type="submit" value="<s:message code="param.submit"/>"/>
    </form:form>
        
<!--     <script type="text/javascript" src="http://js.nicedit.com/nicEdit-latest.js"></script> 
    <script type="text/javascript">
        new nicEditor().panelInstance('textRu');
        new nicEditor().panelInstance('textEn');
    </script>-->
</z:mainLayout>
