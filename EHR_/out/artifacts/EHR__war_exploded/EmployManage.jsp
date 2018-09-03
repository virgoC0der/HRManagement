<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    float: left;
    color: #2A4960;
  }

  #secondForm {
    display: inline;
    float: left;
    font-family: PingFangSC-Regular;
    letter-spacing: 0.32px;
    font-size: 19px;
    box-sizing: border-box;
    margin-top: 0px;
    padding-left: 50px;
    width: 60%;
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
    background-color: #2A4960;
    border-bottom: 3px solid #2A4980;
    /*      border-radius: 9px;*/
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
  
  output{
  	color:black;
  }
	
  #input1{
    
  }
  
  #input2{
    display:none;
  }
</style>
<body>
	<form id="form" action="/EmployManage">
    员工号: <input type="text" name = "Id" id = "input1" />
    <input type="submit" value="查询试用期" /><br />
  </form>
  <form id="secondForm" action="/EmployManageSubmit">
   实习结束日期:  <select name="Year">
                     <option value="null">未结束实习</option>
				     <option value="2000">2000</option>
				     <option value="2001">2001</option>
				     <option value="2002">2002</option>
				     <option value="2003">2003</option>
				     <option value="2004">2004</option>
				     <option value="2005">2005</option>
				     <option value="2006">2006</option>
				     <option value="2007">2007</option>
				     <option value="2008">2008</option>
				     <option value="2009">2009</option>
				     <option value="2010">2010</option>
				     <option value="2011">2011</option>
				     <option value="2012">2012</option>
				     <option value="2013">2013</option>
				     <option value="2014">2014</option>
				     <option value="2015">2015</option>
				     <option value="2016">2016</option>
				     <option value="2017">2017</option>
				     <option value="2018">2018</option>
				     </select>
				      年 <select name="Month">
				      <option value="null">未结束实习</option>
				     <option value="01">01</option>
				     <option value="02">02</option>
				     <option value="03">03</option>
				     <option value="04">04</option>
				     <option value="05">05</option>
				     <option value="06">06</option>
				     <option value="07">07</option>
				     <option value="08">08</option>
				     <option value="09">09</option>
				     <option value="10">10</option>
				     <option value="11">11</option>
				     <option value="12">12</option>
				     </select>
				     月<select name="Day">
				     <option value="null">未结束实习</option>
					<option value="01">01</option>
					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>
					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
                     </select> 日<br />
                      <input type="text" name="Id" id = "input2" />
  </form>
  
      
  <form id="outPutForm">
    姓名：<output><%=request.getAttribute("Name")%></output><br> 开始实习日期:
    <output><%=request.getAttribute("Begin_date")%></output><br> 结束实习日期：
    <output><%=request.getAttribute("End_date")%></output><br>
  </form>
  
  <div id="submit">更改</div>
  <script src="js/jquery.js">
  </script>
  <script>
	  var key = "idForEmploy"
      var storage = window.localStorage
	  $(document).ready(function() {

    	//同步INPUT
    	var getItem = storage.getItem(key)
        if (getItem != null){
           $("#input1").val(getItem)
           $("#input2").val(getItem)
        }
    	
    	 $("#input1").attr("oninput","sameInput()")
         $("#submit").bind("click", clickSendButton)
	  })
	
    
    function sameInput(){
    	$("#input2").val($("#input1").val())
		storage.setItem(key,$("#input1").val())
    }

    function clickSendButton() {
     $("#secondForm").submit()
    }
  </script>
</body>
</html>