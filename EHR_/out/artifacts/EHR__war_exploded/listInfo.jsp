<%--
  Created by IntelliJ IDEA.
  User: sx.chen
  Date: 2018/7/17
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
</head>
<style>
    #form {
        float: left;
        font-family: PingFangSC-Regular;
        letter-spacing: 0.32px;
        font-size: 19px;
        box-sizing: border-box;
        margin-top: 0px;
        padding-left: 50px;
        /*    width: 80%;*/
        float: left;
        color: #2A4960;
    }

    textarea{
        resize: none;
        font-size: 14px;
        width: 460px;
        height: 200px;
        border-color: rgba(0,0,0,0.2);
    }

    #outPutForm {
        display: inline;
        float: right;
        font-family: PingFangSC-Regular;
        letter-spacing: 0.32px;
        font-size: 19px;
        box-sizing: border-box;
        margin-top: 0px;
        padding-right: 50px;
        color: #3396F3;
    }

    output {
        color: #2A4960;
    }
</style>

<body>

<form id="form" action="/QueryList">
    本月入职人员:<br>
    <textarea type="text" readonly = "readonly" >姓名：aaa  员工号：54321  部门：技术部</textarea>
</form>

<form id="outPutForm" action="/QueryList">
    本月离职人员：<br>
    <textarea type="text" readonly = "readonly">姓名：aaa  员工号：54321  部门：行政部</textarea>
</form>


</body>

</html>

