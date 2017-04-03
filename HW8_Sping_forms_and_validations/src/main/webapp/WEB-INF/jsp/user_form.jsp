<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
      <form:label path="email">Email</form:label>
      <form:input path="email"/>
      <form:errors path="email" /><br>
      
      <form:label path="password">Password</form:label>
      <form:password path="password" />
      <form:errors path="password" /><br>
      
      <form:label path="repeatPassword">Repeat password</form:label>
      <form:password path="repeatPassword" />
      <form:errors path="repeatPassword" /><br>
      
      <form:label path="name">Full Name</form:label>
      <form:input path="name"/>
      <form:errors path="name" /><br>
      
      <form:label path="country">Country</form:label>
      <form:select path="country">
          <form:options items="${countryList}" />
      </form:select>
      <form:errors path="country"/><br>
      
      
      <form:radiobutton path="sex" value="${valueMale}"/> Male
      <form:radiobutton path="sex" value="${valueFemale}"/> Female
      <form:errors path="sex"/><br>
      
      <form:label path="newsSubscribe">subscribe for news</form:label>
      <form:checkbox path="newsSubscribe"/>
      
     
      
      <input type="submit" value="Submit" />
    </form:form>
  </body>
</html>
