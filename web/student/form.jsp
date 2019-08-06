<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-08-06
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Student form</h1>
    <s:form action="store">
        Rollnumber <s:textfield name="student.rollNumber"/><br>
        Name <s:textfield name="student.name"/><br>
        Email <s:textfield name="student.email"/><br>
        <s:submit value="Save"/>
    </s:form>
</body>
</html>
