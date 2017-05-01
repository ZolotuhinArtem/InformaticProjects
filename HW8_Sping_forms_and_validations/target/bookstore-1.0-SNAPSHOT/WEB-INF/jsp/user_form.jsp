<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
    <c:if test="${not empty message}">
      <h1>${message}</h1>
    </c:if>
      
    <form:form method="POST" commandName="userForm">
      <form:label path="email"><s:message code="form.email"/></form:label>
      <form:input path="email"/>
      <form:errors path="email" /><br>
      
      <form:label path="password"><s:message code="form.password"/></form:label>
      <form:password path="password" />
      <form:errors path="password" /><br>
      
      <form:label path="repeatPassword"><s:message code="form.repeat_password"/></form:label>
      <form:password path="repeatPassword" />
      <form:errors path="repeatPassword" /><br>
      
      <form:label path="name"><s:message code="form.name"/></form:label>
      <form:input path="name"/>
      <form:errors path="name" /><br>
      
      <form:label path="country"><s:message code="form.country"/></form:label>
      <form:select path="country">
          <form:options items="${countryList}" />
      </form:select>
      <form:errors path="country"/><br>
      
      
      <form:radiobutton path="sex" value="${valueMale}"/> <s:message code="form.sex.male"/>
      <form:radiobutton path="sex" value="${valueFemale}"/> <s:message code="form.sex.female"/>
      <form:errors path="sex"/><br>
      
      <form:label path="newsSubscribe">subscribe for news</form:label>
      <form:checkbox path="newsSubscribe"/>
      
     
      
      <input type="submit" value="Submit" />
    </form:form>
  </body>
</html>
