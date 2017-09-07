<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 20:02
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


<script type="text/javascript" src="../My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
<body>
<form action="<%=basePath%>/user/updateUser.action" method="post">
   <input type="hidden" name="id" value="${myMsg.id}"/>
    <table>
        <tr>
            <td> 用户名:</td>
            <td><input type="text" name="userName" value="${myMsg.userName}"/></td>
        </tr>

        <tr>
            <td>密码:</td>
            <td><input type="password" name="userPassword" value="${myMsg.userPassword}"/></td>
        </tr>

        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="userSex" value="0" <c:if test="${myMsg.userSex==0}">checked="checked"</c:if>"/>男
                <input type="radio" name="userSex" value="1" <c:if test="${myMsg.userSex==1}">checked="checked"</c:if>"/>女
            </td>

        </tr>

        <tr>
            <td>生日:</td>
            <td>
                <input class="Wdate" name="userBirthday" type="text"  value="<fmt:formatDate value="${myMsg.userBirthday}"/>" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd '})" />

            </td>
        </tr>


        <tr>
            <td><input type="submit" value="修改"/></td>
        </tr>
    </table>
</form>
</body>
</html>
