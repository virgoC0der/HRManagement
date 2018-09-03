$(document).ready(function () {
  console.log(name)
  $("#buttonList li").bind("click", clickButton)
  $("#buttonList li:first").trigger("click")
})

function clickButton() {
  $("#buttonList li").css("top", "0px")
  $(this).animate({
    top: "-5px"
  }, 70)
  var name = $(this).html()
  $("#title").html(name)
  $("#frame").fadeOut(100)
  if (name == "入职管理") {
    $("#frame").attr("src", "AddStaff.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "试用期管理") {
    $("#frame").attr("src", "EmployManage.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "部门管理") {
    $("#frame").attr("src", "DepartmentTree.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "岗位管理") {
    $("#frame").attr("src", "JobTree.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "部门调动管理") {
    $("#frame").attr("src", "DepartmentImport.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "岗位调动管理") {
    $("#frame").attr("src", "PostImport.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "信息中心") {
    $("#frame").attr("src", "QueryStaff.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "离职管理") {
    $("#frame").attr("src", "fireSomeone.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }

  if (name == "报表管理") {
      $("#frame").attr("src", "listInfo.jsp")
      $("#frame").hide()
      $("#frame").fadeIn(100)
  }
}


function clearAll() {

}
