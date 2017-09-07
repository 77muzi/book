<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
<title>SSH Framework</title>
</head>
<body>

<center>
<h2>图书列表</h2>
<table>
    <thead>
    <tr>
        <td width="100px;">id</td>
        <td width="100px;">书名</td>
        <td width="100px;">价格</td>
        <td width="100px;">数量</td>
        <td width="100px;">封面</td>
        <td width="100px;">操作</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${bookList}" var="b">
        <tr>
            <td width="100px;">${b.id}</td>
            <td width="100px;">${b.bookName}</td>
            <td width="100px;">${b.bookPrice}</td>
            <td width="100px;">${b.bookCount}</td>
            <td width="100px"><img src="${b.bookImg}" alt=""></td>
            <td width="500px;"><button>购买</button>
                <a href="../jsp/upLoadImg.jsp?id=${b.id}">上传封面</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</center>
</body>
</html>
