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
    margin-top: 30px;
    padding-left: 50px;
    width: 50%;
    float: left;
    color: #2A4960;
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
    text-align: center;
	  width: 40px;
    height: 20px;
    color: white;
    background-color: #2A4960;
    border-bottom: 3px solid #2A4980;
    /*      border-radius: 9px;*/
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
  <form action="/Queryinfo" method="Get" id = "form">
	  员工号: <input type="text" name="Id"/>
  </form>

  <div id="submit">查询</div>
  <script src="js/jquery.js">


  </script>
  <script>
    $(document).ready(function() {
        // alert("newPage")
      $("#submit").bind("click", clickSendButton)
    })

    function clickSendButton() {
      //      alert("submit")
      $("#form").submit()
    }

  </script>
  <form id = "outPutForm">
  员工号:<output><%=request.getAttribute("Id")%></output><br />
			 姓名：<output><%=request.getAttribute("Name")%></output><br />
			 职位：<output><%=request.getAttribute("Post")%></output><br />
			 部门：<output><%=request.getAttribute("Department")%></output><br />
			 等级：<output><%=request.getAttribute("Level")%></output><br />
			 年龄：<output><%=request.getAttribute("Age")%></output><br />
			 语言能力：<output><%=request.getAttribute("Language")%></output><br />
			 职业经历：<output><%=request.getAttribute("Career")%></output><br />
			 家庭关系：<output><%=request.getAttribute("Relationship")%></output><br />
			 入职日期：<output><%=request.getAttribute("In-date")%></output><br />
			 离职日期：<output><%=request.getAttribute("Exit-date")%></output><br />
			 实习开始日期：<output><%=request.getAttribute("Begin-date")%></output><br />
			 实习结束日期：<output><%=request.getAttribute("End-date")%></output><br />
</form>
</body>

</html>

