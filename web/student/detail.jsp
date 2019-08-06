<%--
  Created by IntelliJ IDEA.
  User: xuanhung
  Date: 2019-08-03
  Time: 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
    <h1>Student detail</h1>
    <div>Rollnumber <s:property value="student.rollNumber"/></div>
    <div>Name <s:property value="student.name"/></div>
</body>
</html>
