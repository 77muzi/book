<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src="${imagesPath}"/>
<h2>登录页面</h2>
${result}
<form action="<%=basePath%>/user/userLogin.action" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="userPassword"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录"/>
                <input type="reset" value="重置"/>
            </td>
        </tr>
    </table>
    还没注册?<a href="<%=basePath%>/user/toReg.action">注册</a>
</form>

</body>
</html>
