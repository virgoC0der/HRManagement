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
    width: 100%;
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
    text-align: center width: 40px;
    height: 20px;
    color: white;
    background-color: red;
    border-bottom: 3px solid red;
    /*      border-radius: 9px;*/
  }
</style>

<body>
  <form id="form" action="http://localhost:8080/ehr_/FireStaff">
    员工号: <input type="text" name="Id"/>
    <input type="submit" value="查询信息" />
  </form>
  <div id="submit">离职</div>
  <script src="jquery.js">
  </script>
  <script>
    $(document).ready(function() {
      $("#submit").bind("click", clickSendButton)
    })

    function clickSendButton() {
      alert("submit")
      $("#form").submit()
    }
  </script>
			 Id<%=request.getAttribute("Id")%><br />
  Name<%=request.getAttribute("Name")%><br />
  Post<%=request.getAttribute("Post")%><br />
  Department<%=request.getAttribute("Department")%><br />
			 Level<%=request.getAttribute("Level")%><br />
			 Age<%=request.getAttribute("Age")%><br />
			 Language<%=request.getAttribute("Language")%><br />
			 Career<%=request.getAttribute("Career")%><br />
			 Relationship<%=request.getAttribute("Relationship")%><br />
			 In-date<%=request.getAttribute("In-date")%><br />
			 Exit-date<%=request.getAttribute("Exit-date")%><br />
			 Begin-date<%=request.getAttribute("Begin-date")%><br />
			 End-date<%=request.getAttribute("End-date")%><br />
</body>

</html>
