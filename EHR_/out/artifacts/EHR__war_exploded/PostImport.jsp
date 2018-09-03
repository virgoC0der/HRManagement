<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
</head>
<style>
  .box {
    width: 200px;
    height: 200px;
    background: skyblue;
    text-align: center;
    /*水平居中*/
    line-height: 200px;
    /*垂直居中   行高(line-height)需与该div的高度值(height)一致*/
    overflow: hidden;
    /*防止内容超出容器或产生自动换行*/
  }

  #form {
    float: left;
    font-family: PingFangSC-Regular;
    letter-spacing: 0.32px;
    font-size: 19px;
    box-sizing: border-box;
    margin-top: 0px;
    padding-left: 50px;
    width: 60%;
    color: #2A4960;
  }
  
  #form2 {
    float: left;
    font-family: PingFangSC-Regular;
    letter-spacing: 0.32px;
    font-size: 19px;
    box-sizing: border-box;
    margin-top: 0px;
    padding-left: 50px;
    width: 60%;
    color: #2A4960;
  }

  #outPutForm {
    display:inline;
    float: right;
    font-family: PingFangSC-Regular;
    letter-spacing: 0.32px;
    font-size: 19px;
    box-sizing: border-box;
    margin-top: 0px;
    padding-right: 50px;
    color: #3396F3;
  }

  input {
    font-size: 17px;
    padding: 2px 7px;
    margin-top: 4px;
    margin-bottom: 5px;
  }

  select {
    font-size: 15px;
    margin-left: 3px;
    margin-right: 3px;
  }

  textarea {
    width: 100px;
    height: 30px;
    padding: 5px 5px;
    /*
      float: left;
      clear: both;
*/
  }

  .smallInput {
    width: 70px;
  }

  textarea {
    resize: none;
    font-size: 14px;
    width: 360px;
    height: 40px;
    border-color: rgba(0, 0, 0, 0.2);
  }

  #submit {
    cursor: pointer;
    /*      float: right;*/
    position: fixed;
    top: 390px;
    left: 980px;
    margin-top: 6px;
    margin-bottom: 27px;
    padding: 6px 22px;
    font-weight: 400;
    text-align: center width: 40px;
    height: 20px;
    color: white;
    background-color: #2A4960;
    border-bottom: 3px solid #2A4980;
    /*      border-radius: 9px;*/
  }

  output {
    color: #2A4960;
  }
  
  #sendButton{
    display: none;
  }
  
  #selectButton{
    
  }
  #input1{
    
  }
  
  #input2{
    display:none;
  }

</style>

<body>
  <form id="form" action='/PostImport'>
    员工号: <input type="text" name="Id" id = "input1"/>
     <button type='submit' id = "selectButton">点击查询</button>
  </form>

    <form action="/PostImportSubmit" id="form2">
    部门:   <select name="Department" id="first-option" onChange="change()">
        <option value="技术部">技术部</option>
        <option value="客服部">客服部</option>
        <option value="市场部">市场部</option>
        <option value="行政部">行政部</option>
			</select> 职位: <select name="Post" id="second-option">
        <option value="技术主管">技术主管</option>
        <option value="研发主管">研发主管</option>
        <option value="产品开发工程师">产品开发工程师</option>
        <option value="产品开发技术员">产品开发技术员</option>
				</select>
				  <input type="text" name="Id" id = "input2" />
				 <button type='submit' id = "sendButton">点击提交</button>
     </form>
     
     
  <form id="outPutForm">
    姓名：<output><%=request.getAttribute("Name")%></output><br> 现在所在部门:
    <output><%=request.getAttribute("Department")%></output><br> 职务：
    <output><%=request.getAttribute("Post")%></output><br>
  </form>
    <div id="submit">更改</div>

  
  
 <script src = "js/jquery.js"></script>
  <script>
  	var key = "idForPost"
	var storage = window.localStorage
    $(document).ready(function() {
    	//同步INPUT
    	var getItem = storage.getItem(key)
        if (getItem != null){
           $("#input1").val(getItem)
           $("#input2").val(getItem)
        }
    	//绑定按钮
      $("#submit").bind("click", clickSendButton)
      $("#input1").attr("oninput","sameInput()")
    })
    

    function clickSendButton() {
      $("#sendButton").trigger("click")
      $("#outPutForm").css("display","inline")
    }
    
    function sameInput(){
    	storage.setItem(key,$("#input1").val())
    	$("#input2").val($("#input1").val())
    }

    function change() {
      var x = document.getElementById("first-option");
      var y = document.getElementById("second-option");
      y.options.length = 0; // 清除second下拉框的所有内容
        if (x.selectedIndex == 0) {
            y.options.add(new Option("技术主管", "技术主管"));
            y.options.add(new Option("研发主管", "研发主管"));
            y.options.add(new Option("产品开发工程师", "产品开发工程师"));
            y.options.add(new Option("产品开发技术员", "产品开发技术员"));
        }

        if (x.selectedIndex == 1) {
            y.options.add(new Option("客服主管", "客服主管"));
            y.options.add(new Option("客服人员", "客服人员"));
        }

        if (x.selectedIndex == 2) {
            y.options.add(new Option("产品主管", "产品主管"));
            y.options.add(new Option("市场调研主任", "市场调研主任"));
            y.options.add(new Option("公共主管", "公共主管"));
            y.options.add(new Option("广告策划主管", "广告策划主管"));
        }

        if (x.selectedIndex == 3) {
            y.options.add(new Option("部门经理", "部门经理"));
            y.options.add(new Option("行政主管", "行政主管"));
            y.options.add(new Option("人事主管", "人事主管"));
            y.options.add(new Option("行政助理", "行政助理"));
        }
    }

  </script>

</body>

</html>
