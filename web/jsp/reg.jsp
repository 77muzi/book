<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/19
  Time: 14:39
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
<script type="text/javascript" src="../My97DatePickerBeta/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
  $(function () {
     var rname=false;
     var rpass=false;
     var rrepass=false;
     var rbirthday=false;

      $("#name").blur(function(){
          var name=$("#name").val();
         name= encodeURI(name);
          $("#checkName").text("");
          if(name==null || name==""){
              $("#checkName").html("用户名不能为空").css("color","red");
              return ;
          }
          $.ajax({
              type:"get",
              url:"<%=basePath%>/user/checkName.action",
              data:{"name":name},
              dataType:"text",
              success:function(data){
                  if(data=="true"){
                      $("#checkName").html("用户名已存在").css("color","red");
                      return ;
                  }else{
                      $("#checkName").html("用户名不存在,可以注册").css("color","green");
                      return rname==true;
                  }
              },
              error:function () {
                  alert("系统错误");
              }
          });
      });

      /*密码*/
      $("#pass").blur(function(){
          var password=$(this).val();
          $("#checkPass").text("");
          if(password==null || password==""){
              $("#checkPass").html("密码不能为空").css("color","red");
              return ;
          }else{
              return rpass=true;
          }
      });

      /*确认密码*/
      $("#repass").blur(function(){
         var repss= $(this).val();
         var pass=$("#pass").val();

         if(repss!=pass){
             $("#checkRepass").html("两次密码不一致").css("color","red");
             return ;
         }else{
             $("#checkRepass").html("两次密码一致").css("color","green");
             $("#checkRepass").text("");
             return repss=true;
         }
      });

      /*出生日期*/
      $("#birthday").blur(function(){
          var birthday=$(this).val();
          $("#checkBirthday").text("");
          if(birthday==null || birthday==""){
              $("#checkBirthday").html("生日不能为空").css("color","red");
              return ;
          }else{
              return rbirthday=true;
          }
      });
      
      $("form").submit(function () {
          if(rbirthday && rrepass && rpass && rname ==false){
              return false;
          }else{
              alert("注册成功");
              return true;
          }
      });


  });



</script>
<body>
  <h2>注册页面</h2>
<form action="<%=basePath%>/user/userReg.action" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="userName" id="name" /><span id="checkName"></span></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="userPassword" id="pass"/><span id="checkPass"></span></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="password" name="reUserPassword" id="repass"/><span id="checkRepass"></span></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                <input type="radio" name="userSex" value="0" checked="checked"/>男
                <input type="radio" name="userSex" value="1"/>女
            </td>
        </tr>
        <tr>
            <td>生日:</td>
            <td>
                <input class="Wdate" name="userBirthday" id="birthday" type="text"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd '})" />
                <span id="checkBirthday"></span>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="注册">
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
