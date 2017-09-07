<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("button").click(function () {
            var msg = $("#msg").val();  //获取文本域的内容
         /*  msg = encodeURI(msg);*/ //解决中文乱码

           var argent= $('input:radio:checked').val();
         /*  argent=encodeURI(argent);*/

            var arr_ids = []; //定义一个数组
            var obj = $("input[name='id']:checked");
            for (k in obj) {
                if (obj[k].checked) {
                    arr_ids.push(obj[k].value);
                };
            }
            $.ajax({
                type: "post",
                url: "<%=basePath%>/message/addMessage.action",
                data: {"ids": arr_ids.join(","), "msg": msg,"argent":argent},
                dataType: "json",
                success: function (data) {
                  count=  data.result;
                    if (count == 1) {
                        alert("发送成功");
                        $("#msg").val("");
                        $(":checkbox").removeAttr("checked");
                        $(":radio").removeAttr("checked");
                    } else {
                        alert("发送失败");
                    }
                },
                error: function () {
                    alert("系统错误");
                }
            });


        });
    });
</script>
<body>
<center>
    <h1>站内信发送页面</h1>
    <table border="1">
        <tr>
            <td>请选择联系人</td>
            <td>
                <c:forEach items="${names }" var="u">
                    <input type="checkbox" name="id" id="ids" value="${u.id }"/>${u.userName }
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>请选择紧急程度</td>
           <td>
               <input type="radio" name="argent" value="0"/>一般
               <input type="radio" name="argent" value="1"/>重要
               <input type="radio" name="argent" value="2"/>紧急
           </td>
        </tr>
        <tr>
            <td>请输入信息内容</td>
            <td>
                <textarea rows="3" cols="50" id="msg" name="content"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <button >发送</button>
            </td>
        </tr>
    </table>

</center>
</body>
</html>
