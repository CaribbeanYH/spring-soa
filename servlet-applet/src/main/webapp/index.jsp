<%@ page import="com.mysql.cj.util.StringUtils" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - HOME</title>
</head>
<script>
    function onsubmit() {
        //http
        Ajax.post("/home/heroInfo", {
            name: $("#name").val(),
            age: $("#age").val()
        }, function (data) {
            if (data) {
                alert("添加成功");
            } else {
                alert("添加失败");
            }
        })
    }
</script>
<body>
<h1><%= "我的第一个Web应用!" %>
</h1>
<br/>
<a href="home-servlet">Hello Servlet</a>
<a href="hero">黄忠</a>
<%
    String title = "我的第一个JSP页面";
    if (StringUtils.isNullOrEmpty(title)) {
        System.out.println("我是内嵌JSP的java代码");
    }
%>/>
<form id="user">
    <label for="姓名"></label><input id="name" type="text" name="username"/>
    <label for="年龄"></label><input id="age" type="number" name="userage"/>
    <button onclick="onsubmit()">提交</button>
</form>
<form id = "form2">

</form>
</body>
</html>