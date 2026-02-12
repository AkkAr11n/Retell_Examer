<%@ page import="com.tju.examsystem.domain.PaperGrade" %>
<%@ page import="com.tju.examsystem.domain.Teacher" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>教师信息</title>
  <style type="text/css">
    #a1{width: 30%;height: 90px;float: left;}
    #a2{width: 55%;height: 40px;float: left;text-align: right;padding-top: 35px;z-index: 1;}
    #t1{width: 100%;height: 500px;}
    #table{width: 100%;text-align: center;border-color: #6495ED;border: 0px solid #6495ED;}
    .table{width: 80%;float: left;height: 400px;}
    #addinfo{width: 400px;height: 320px; text-align: left;float: left;box-shadow: 0px 0px 35px 0px #6495ED;
      z-index: 3;background-color: white;position: absolute;left: 25%;top: 18%;border-radius: 27px 0px 27px 27px;}
    th{border: 1px solid ghostwhite;}
    th{height: 40px;background-color: #6495ED;}
    td{border: 1px solid floralwhite;height: 30px;}
    tr:hover{background-color: #999999;height: 37px;}
    #td{border: 3px solid #000000;width: 60px;height: 40px;background-color: #6495ED;}
    #add{width: 140px;height: 40px;text-decoration: none;background-color: #6495ED;border: 3px solid #000000;
      color: #F0F8FF;padding:10px 10px 10px 10px;margin-right: 10%;border-radius: 6px 6px 6px 6px;}
    #add:hover{color: #000000;}
    select{height: 40px;border: 2px solid #000000;border-radius: 3px 3px 3px 3px;
      margin-right: 40px;margin-left: 20px;
    }
    .a10 .ss1{height: 40px;border: 2px solid #000000;border-radius: 3px 3px 3px 3px;width: 80px;
      margin-right: 40px;margin-left: 20px;font-size: 16px;
    }
    #form1{font-size: larger;padding-left: 20px;text-align: center;}
    input{width: 65%;height: 25px;border-radius: 6px 6px 6px 6px;margin-top: 10px;}
    #btn_update,#btn_ext,#btn_add{width: 120px;height: 40px;border-radius: 6px 6px 6px 6px;margin:0 auto;background-color: #6495ED;}
    #btn_add{color: white;}
    #btn_ext{color: white;}
    #btn_add :hover{color: #999999;}
    #btn_ext :hover{color: antiquewhite;}
    .xiu{border-radius: 3px 3px 3px 3px;border: 1px solid bisque;padding: 5px;box-shadow: 0px 0px 30px 0px #DCDCDC;background-color: coral;}
    .xiu:hover{color: #BD0A01;}
    .xiu2{border-radius: 3px 3px 3px 3px;border: 1px solid bisque;padding: 5px;box-shadow: 0px 0px 30px 0px #DCDCDC;background-color:springgreen;}
    .xiu2:hover{color: #BD0A01;}
    #h4{width: 94%;float: left;padding-top: 15px;font-size: larger;height: 30px;padding-left: 0px;border-radius: 0px 0px 50% 50%/0px 0px 40px 40px;background-color: #6495ED;}
    #h3{width: 5%;float: right;height: 20px;padding:0;text-align: right;margin: 0 auto;}
    /* #h2{width: 100%;float: left;height: 40px;border-radius: 0px 0px 50% 50%/0px 0px 30px 30px;background-color: #6495ED;} */
    #span1{width: 20px;font-size: x-large;line-height: 10px;}
    #h3 :hover{background-color: #DCDCDC;}
    #aa2{float: left;width: 15%;}
    #aa3{width: 80%;height: 320px;float: left;}
    #shu{height: 320px;}
    .a10 .a9{width: 70px;height: 20px;background-color: #fff;position: absolute;left:200px;bottom:0px;}
    .a10{width: 100%;height: 50px;margin-top: 0px;background-color:#dcdcdc;float: left;font-size:larger;padding-left:20px;}
    .dao{border-radius: 3px 3px 3px 3px;box-shadow: 0px 0px 30px 0px #DCDCDC;background: white;width: 70px;height:40px;float:left;margin-right:20px;}
    #alldiv{
      overflow: auto;
    }
  </style>
  <script type="text/javascript">
    function del(teacherId){
      const ok = window.confirm("确认删除吗T T");
      if(ok){
        alert("正在删除数据，请稍后");
        document.location.href="<%= request.getContextPath() %>/teacher/delete?teacherId="+teacherId;
      }
    }
  </script>
  <script type="text/javascript">
    window.onload = function(){
      var box = document.getElementById("addinfo");
      var box1=document.getElementById("h4");
      var box2=document.getElementById("aa2")
      box1.onmousedown = function(){
        document.onmousemove = function(event){
          event = event || window.event;
          var left = event.clientX;
          var top = event.clientY;
          box.focus();
          box.style.left = left +"px";
          box.style.top = top +"px";

          document.onmouseup = function(){
            document.onmousemove = null;
            document.onmouseup = null;
          };
        };
      };
    };


    //----清除添加信息框的内容-----
    function cleanAddInput(){
      document.getElementById('academy').value='';
      document.getElementById('teacherId').value='';
      document.getElementById('name').value='';

    }
    //----清除添加信息框的内容-----

    //----显示添加信息框-----
    function showAddInput(){
      document.getElementById('addinfo').style="display:block-inline" ;
      document.getElementById('btn_add').style="display:block-inline" ;
      document.getElementById('btn_update').style="display:none" ;
      cleanAddInput();
      document.getElementById("teacherId").readOnly = false;
      document.getElementById("form1").action="<%=request.getContextPath()%>/teacher/add";
    }
    //----显示添加信息框-----

    //----隐藏添加信息框-----
    function hideAddInput(type){
      document.getElementById('addinfo').style="display:none" ;
      let teacherId=document.getElementById('teacherId').value;
      let academy=document.getElementById('academy').value;
      let name=document.getElementById('name').value;
      if(teacherId==""||academy==""||name=="")
      {
        alert("请把数据补充完整！");
        return false;
      }else
      {
        if(type==0) alert("添加成功");
        else alert("修改成功")
      }
      return true;
    }
    //----隐藏添加信息框-----


    //----根据行号修改信息-----
    function showUpdate(teacherId,academy,name){
      document.getElementById('addinfo').style="display:block-inline" ;
      document.getElementById('btn_add').style="display:block-inline" ;
      document.getElementById('btn_update').style="display:none" ;
      cleanAddInput();
      document.getElementById('teacherId').value=teacherId;
      document.getElementById('academy').value=academy;
      document.getElementById('name').value=name;
      document.getElementById("teacherId").readOnly = true;
      document.getElementById("form1").action="<%=request.getContextPath()%>/teacher/update";
      //提交按钮替换
      document.getElementById('btn_add').style="display:none" ;
      document.getElementById('btn_update').style="display:block-inline" ;
    }
    //----根据行号修改信息-----

  </script>
</head>
<body>
<div id="a1">
  <h2><font style="color: #6495ED;">~~教师信息~~</font></h2>
</div>
<div id="a3">

</div>
<div id="a2">
  <a href="javascript:void(0)" onclick="javascript:showAddInput();" id="add">添加教师</a>
</div>
<div class="table" id="alldiv">
  <table border="1" style="text-align:center" id="table" cellspacing="0">
    <tr>
      <th>编号</th>
      <th>工号</th>
      <th>院系</th>
      <th>姓名</th>
      <th>操作</th>
    </tr>

    <%
      List<Teacher> allTeacher= (List<Teacher>) request.getAttribute("allTeacher");
      int i=0;
      for(Teacher tea:allTeacher){
    %>
    <tr>
      <td><%=++i %></td>
      <td><%=tea.getTeacherId()%></td>
      <td><%=tea.getAcademy()%></td>
      <td><%=tea.getName()%></td>
      <td><a style="color:#6495ED;cursor:pointer;"
             onclick="showUpdate('<%=tea.getTeacherId()%>','<%=tea.getAcademy()%>','<%=tea.getName()%>');"
             class="xiu">修改</a>&nbsp<a style="color:chocolate;
             cursor:pointer;" onclick="del('<%=tea.getTeacherId()%>')" class="xiu2">删除</a></td>
    </tr>
    <%
      }
    %>
  </table>
</div>
<div id="addinfo" style="display: none;" title="点击鼠标以固定，滑动鼠标拖动">
  <!-- <div id="aa2">
      <img src="img/书本.jpg" align="right" height="400px" id="shu">
      </div> -->
  <!-- <div id="aa3"> -->
  <form action="<%=request.getContextPath()%>/teacher/add" method="post" id="form1">
    <center>
      <div id="h4"> <b>~~请添加信息~~</b></div></center><div id="h3">
    <span style=" color: black;cursor:pointer;" onclick="hideAddInput()" id="span1">×</span>
    </div> <br>
    <input type="text" name="teacherId" id="teacherId" placeholder="请输入工号"/><br>
    <input type="text" name="academy" id="academy" placeholder="请输入学院"/><br>
    <input type="text" name="name" id="name" placeholder="请输入姓名"/><br>
    <center><div><input type="submit" value="提交" onclick="return hideAddInput(0);" id="btn_add" >
      <input type="submit" value="提交" onclick="return hideAddInput(1);" style="display:none" id="btn_update">
    </div></center>
  </form>

</div>


</body>
</html>
