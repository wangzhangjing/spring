<%--
  Created by IntelliJ IDEA.
  User: 86176
  Date: 2022/6/26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        var userList=new Array();
        userList.push({username:"zhangsan",age:18});
        userList.push({username:"lisi",age:20});
        $.ajax({
           type:"POST",
           url:"${pageContext.request.contextPath}/user/quick15",
           data:JSON.stringify(userList),
           contentType:"application/json;charset=utf-8"
        });
    </script>
</head>
<body>

</body>
</html>
