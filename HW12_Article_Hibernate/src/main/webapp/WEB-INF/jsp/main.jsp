<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="z" %>

<z:mainLayout>
    <h1><s:message code="param.hello"/></h1>
    <a href="${s:mvcUrl('AC#addForm').build()}">
        <s:message code="param.add"/>
    </a>
    <ul class="list-group">
        <c:forEach var="i" items="${articles}">
            <li class="list-group-item"><a href="${s:mvcUrl('AC#show').arg(0, i.getSlug()).build()}">${i.getTitle()}</a></li>
       </c:forEach>
            <nav aria-label="Page navigation">
                <ul class="pagination">
                  
                  <c:if test="${page > 1}">
                    <li>
                      <a href="?page=${page - 1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                      </a>
                    </li>
                  </c:if>
                    
                  <c:forEach var="i" begin="1" end="${page_count}">
                      <li><a href="?page=${i}">${i}</a></li>
                  </c:forEach>
                      
                  <c:if test="${page < page_count}">
                    <li>
                      <a href="?page=${page + 1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                      </a>
                    </li>
                  </c:if>
                </ul>
              </nav>
    </ul>
</z:mainLayout>
