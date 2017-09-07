<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/16
  Time: 11:14
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
<script type="text/javascript " src="../js/jquery.min.js"></script>
<script type="text/javascript">
    function deleteById(mid) {
        $.ajax({
            type: "get",
            url: "<%=basePath%>/message/deleteMessage.action",//需要用来处理ajax请求的action
            data: {//设置数据源
                "mid": mid
            },
            dataType: "text",//设置需要返回的数据类型
            success: function (data) {
                if (data == "true") {
                    alert("删除成功");
                    // window.location.reload(true);
                    // window.location.href="/message/queryById.action";
                    readmsg();
                }
                else {
                    alert("删除失败");
                }
            },
            error: function () {
                alert("系统异常，请稍后重试！");
            }
        });
    }


    function readmsg() {
        var id = $("#msg").val();
        if (id == "") {
            window.location.href = "<%=basePath%>/message/queryMessages.action";
        } else {
            $.ajax({
                type: "get",
                url: "<%=basePath%>/message/queryById.action",
                data: {"id": id},
                dataType: "json",
                success: function (data) {

                    var str = "";
                    for (i in data) {
                        if(data[i].argent==0){
                            data[i].argent='一般';
                        }
                        else  if(data[i].argent==1){
                            data[i].argent='重要';
                        }
                        else if(data[i].argent==2){
                            data[i].argent='紧急';
                        }
                        str += "<tr style='height: 50px;'>"
                            + "<td width='200px;'><input type='checkbox' name='id' id='ids' value=" + data[i].mid + " /></td>"
                            + "<td width='200px;'>" + data[i].mid + "</td>"
                            + "<td width='200px;'>" + data[i].content + "</td>"
                            + "<td width='200px;'>" + data[i].createtime + "</td>"
                            + "<td width='200px;'>" + data[i].user.userName + "</td>"
                            + "<td width='200px;'>" + data[i].argent + "</td>"
                            + "<td width='200px;'><a style='cursor: pointer' onclick='deleteById(" + data[i].mid + ")'>删除</a></td>" + "</tr>"
                    }
                    str += "<tr>" + "<td colspan='7'><button onclick='deleteAll()'>批量删除</button></td>" + "</tr>"
                    var tbody = document.getElementById("tbodyResult");
                    tbody.innerHTML = str;
                },
                error: function () {
                    alert("系统错误");
                }
            });
        }
    }

    function deleteAll() {
        var arr_ids = []; //定义一个数组
        var obj = $("input[name='id']:checked");
        for (k in obj) {
            if (obj[k].checked) {
                arr_ids.push(obj[k].value);
            };

        }
        $.ajax({
            type: "get",
            url: "<%=basePath%>/message/deleteByIds.action",
            data: {"ids": arr_ids.join(",")},
            dataType: "text",
            success: function (data) {
                if (data == "true") {
                    alert("删除成功");
                    //window.location.reload(true);
                    readmsg();
                } else {
                    alert("删除失败");
                }
            },
            error: function () {
                alert("系统错误");
            }
        });
    }




    $(function () {
        $("#all").click(function(){
            $("input[name='id']").each(function () {
                if($(this).prop("checked")){
                    $(this).removeAttr("checked");
                }else{
                    $(this).prop("checked","true");
                }
            });
        });
    });


</script>
<body>
<center>
    <h1>站内信查看页面</h1>


    <select id="msg" onchange="readmsg()">
        <option value="" selected>所有用户</option>
        <c:forEach items="${names }" var="n">
            <option value="${n.id }">${n.userName }</option>
        </c:forEach>
    </select>

<form action="<%=basePath%>/message/getMsgByName.action" method="post">
   <input type="text" name="userName" />
    <input type="submit" value="模糊查询"/>
</form>
    <table>
        <thead>
        <tr>
            <td width="200px;"><input type="checkbox" id="all"/></td>
            <td width="200px;" align="left">消息id</td>
            <td width="200px;" align="left">消息内容</td>
            <td width="200px;" align="left">时间</td>
            <td width="200px;" align="left">接收人</td>
            <td width="200px;" align="left">紧急状态</td>
            <td width="200px;" align="left">操作</td>
        <tr>
        </thead>
        <tbody id="tbodyResult">
        <c:forEach items="${messages }" var="m">
            <tr style="height: 50px;">
                <td width="200px;"><input type="checkbox" value="${m.mid}" id="ids" name="id"/></td>
                <td width="200px;">${m.mid }</td>
                <td width="200px;">${m.content }</td>
                <td width="200px;">${m.createtime }</td>
                <td width="200px;">${m.user.userName}</td>
                <td width="200px;">
                    <c:if test="${m.argent==0}">一般</c:if>
                    <c:if test="${m.argent==1}">重要</c:if>
                    <c:if test="${m.argent==2}">紧急</c:if>
                </td>
                <td width="200px;"><a style="cursor: pointer" onclick="deleteById(${m.mid})">删除</a></td>
            </tr>
        </c:forEach>
        </tr>
        <tr>
            <td colspan="7">
                <button onclick="deleteAll()">批量删除</button>
            </td>
        </tr>
        </tbody>
    </table>

</center>
</body>
</html>
