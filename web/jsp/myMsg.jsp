<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h2>个人中心</h2>
        <table>
            <tr>
                <td> 用户名:</td>
                <td>${myMsg.userName}</td>
            </tr>

            <tr>
                <td>密码:</td>
                <td>${myMsg.userPassword}</td>
            </tr>

            <tr>
                <td>性别:</td>
                <td>
                    <c:if test="${myMsg.userSex==0}">男</c:if>
                    <c:if test="${myMsg.userSex==1}">女</c:if>
                </td>

            </tr>

            <tr>
                <td>生日:</td>
                <td><fmt:formatDate value="${myMsg.userBirthday}"/></td>
            </tr>

            <tr>
                <td>年龄:</td>
                <td>${myMsg.age}</td>
            </tr>

            <tr>
                <td><a href="<%=basePath%>/user/toUpdate.action?id=${myMsg.id}"><button>修改</button></a></td>
            </tr>
        </table>



</body>
</html>
