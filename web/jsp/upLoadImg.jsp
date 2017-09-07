<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/19
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    String bookid = request.getParameter("bookid");
%>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/ajaxfileupload.js"></script>
  <script type="text/javascript">
     function up() {
        $.ajaxFileUpload(
            {
                type:"psot",
                url:"<%=basePath%>/book/upload.action?bookid=<%=bookid%>",
                secureuri:"false",
                fileElementid:"fileImg",
                dataType:"json",
                success:function () {
                    window.location.href="<%=basePath%>/book/queryAllBooks.action";
                },
                error:function () {
                    alert("异常");
                }
            }
        )
     }

  </script>
<body>
<%
    String id=request.getParameter("id");

%>
<form action="<%=basePath%>/book/upload.action" method="post" enctype="multipart/form-data">
    选择文件:
    <input type="file" name="imgfile" width="120px" id="fileImg">
    <input type="submit" value="上传">
    <input type="hidden" name="id" value="<%=id%>"/>

</form>
<img src="${fileUrl}">
</body>
</html>
