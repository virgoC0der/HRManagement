$(document).ready(function () {

  $("#buttonList li").bind("click", clickButton)
  $("#buttonList li:first").trigger("click")
})

function clickButton() {
  $("#buttonList li").css("top", "0px")
  $(this).animate({
    top: "-5px"
  }, 70)
  name = $(this).html()
  $("#title").html(name)
  $("#frame").fadeOut(100)
  if (name == "入职管理") {
    $("#frame").attr("src", "StaffManagement/newEmploye.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "试用期管理") {
    $("#frame").attr("src", "StaffManagement/intern.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "部门管理") {
    $("#frame").attr("src", "StaffManagement/departmentTree.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "岗位管理") {
    $("#frame").attr("src", "StaffManagement/jobTree.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  // if (name == "岗位管理") {
  //   $("#frame").attr("src", "StaffManagement/jobTree.html")
  //   $("#frame").hide()
  //   $("#frame").fadeIn(100)
  // }
  if (name == "部门调动管理") {
    $("#frame").attr("src", "StaffManagement/departmentChange.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "岗位调动管理") {
    $("#frame").attr("src", "StaffManagement/jobChange.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "信息中心") {
    $("#frame").attr("src", "StaffManagement/employeeInformation.html")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
  if (name == "离职管理") {
    $("#frame").attr("src", "fireSomeone.jsp")
    $("#frame").hide()
    $("#frame").fadeIn(100)
  }
}


function clearAll() {

}
