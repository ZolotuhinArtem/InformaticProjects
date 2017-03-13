<%-- 
    Document   : main
    Created on : 03.03.2017, 17:43:53
    Author     : arch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="z" %>

<z:mainLayout title="Main Page">
    <script type="text/javascript" src="<c:url value="/resources/js/main-page.js"/>"></script>
    <input id="path" type="hidden" value="${s:mvcUrl('DC#calculate').build()}"/>
        <form id="calculate-form">
            <input id="input-first-number" class="field" type="text"/>
            <select id="calculate-operation" class="field">
                <option value="add">+</option>
                <option value="sub">-</option>
                <option value="div">/</option>
                <option value="mult">*</option>
                <option value="pow">^</option>
            </select>
            <input id="input-second-number" class="field" type="text"/>
            <div class="field" id="result-holder"></div>
            <div><input id="calculate-btn" class="field" type="submit" value="Calculate"/></div>
            
        </form>
</z:mainLayout>
