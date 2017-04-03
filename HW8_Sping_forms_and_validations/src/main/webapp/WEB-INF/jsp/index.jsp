<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <ul>
            <li><a href="${s:mvcUrl('JFC#registration').build()}">Registration JS303[Normal work, but not compare passwords]</a></li>
            <li><a href="${s:mvcUrl('SFC#registration').build()}">Registration Spring [Good work]</a></li>
        </ul>
    </body>
</html>
