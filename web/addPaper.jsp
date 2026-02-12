
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" http-equiv="Page-Enter" content="RevealTrans(duration=5,Transtionv=2)">
  <title></title>
  <style type="text/css">
    #a1{width: 40%;height: 360px;float: left;}
    #a2{width: 60%;height: 360px;float: left;}
    #a3{width: 80%;height: 360px;float: left;text-align: center;margin: 45px;}
    label{font-size: x-large;}
    .i1{width: 210px;height: 30px; border-radius: 7px 7px 7px 7px;}
    #i2{zoom: 2;}
    select{height: 40px;border: 2px solid deeppink;border-radius: 3px 3px 3px 3px;
    }
    option{height: 20px;}
    #i3{width: 180px;background-color: #6495ED;height: 50px;margin-left: 20%;font-size: x-large;float: left;}
  </style>
  <script type="text/javascript">
    function isNumber(str){
      const reg=/^(0|[1-9][0-9]*)$/;
      if(reg.test(str)) return true;
      else return false;
    }
    function check(){
      let title=document.getElementById("title").value.trim();
      if(title==""){
        alert("试卷名不能为空！");
        return false;
      }
      let difficulty = document.getElementById("difficulty").value;
      let singleCnt = document.getElementById("singleCnt").value;
      let singleMark = document.getElementById("singleMark").value;
      let multipleCnt = document.getElementById("multipleCnt").value;
      let multipleMark = document.getElementById("multipleMark").value;
      let estimateCnt = document.getElementById("estimateCnt").value;
      let estimateMark = document.getElementById("estimateMark").value;
      let fillCnt = document.getElementById("fillCnt").value;
      let fillMark = document.getElementById("fillMark").value;
      if(difficulty==3&&singleCnt==""&&singleMark==""&&multipleCnt==""&&multipleMark==""
              &&estimateCnt==""&&estimateMark==""&&fillCnt==""&&fillMark==""){
        alert("自动分配中");
        return true;
      }
      if(difficulty==3||singleCnt==""||singleMark==""||multipleCnt==""||multipleMark==""
              ||estimateCnt==""||estimateMark==""||fillCnt==""||fillMark==""){
        alert("请把数据补充完整！");
        return false;
      }else{
        if(isNumber(singleCnt)&&isNumber(singleMark)&&isNumber(multipleCnt)&&isNumber(multipleMark)
                &&isNumber(estimateCnt)&&isNumber(estimateMark)&&isNumber(fillCnt)&&isNumber(fillMark)){
          if(Number(singleCnt)*Number(singleMark)+Number(multipleCnt)*Number(multipleMark)
                  +Number(estimateCnt)*Number(estimateMark)+Number(fillCnt)*Number(fillMark)!=100){
            alert("您所设定的分数不等于100分哦！");
            return false;
          }else{
            alert("正在组卷中OvO");
            return true;
          }
        }else{
          alert("本系统很脆弱的，请不要输入奇怪的字符～QAQ");
          return false;
        }
      }
    }

  </script>
</head>
<body>
<h2>~~添加试卷~~</h2>
<form action="<%=request.getContextPath()%>/paper/addPaper" method="post">
  <div id="a1">
    <label>试卷信息</label><br>
    <input type="text" name="title" id="title" class="i1" placeholder="请输入试卷名称"/><br>
    <select id="difficulty" name="difficulty">
      <option value="3">--请选择试卷难度--</option>
      <option value="0">简单</option>
      <option value="1">中等</option>
      <option value="2">困难</option>
    </select><br><br>
    <label>单选题</label><br>
    <input type="text" name="singleCnt"  id="singleCnt"  class="i1"  placeholder="请输入单选题数"/><br>
    <input type="text" name="singleMark" id="singleMark" class="i1" placeholder="请输入每个单选题分数"/><br><br>
    <label>多选题</label><br>
    <input type="text" name="multipleCnt" id="multipleCnt" class="i1" placeholder="请输入多选题数"/><br>
    <input type="text" name="multipleMark" id="multipleMark" class="i1" placeholder="请输入每个多选题分数"/><br><br>

  </div>
  <div id="a2">
    <label>判断题</label><br>
    <input type="text" name="estimateCnt"  id="estimateCnt" class="i1" placeholder="请输入判断题数"/><br>
    <input type="text" name="estimateMark" id="estimateMark" class="i1"  placeholder="请输入每个判断题分数"/><br>
    <label>填空题</label><br>
    <input type="text" name="fillCnt" id="fillCnt" class="i1"  placeholder="请输入填空题数"/><br>
    <input type="text" name="fillMark" id="fillMark" class="i1"  placeholder="请输入每个填空题分数"/><br>
  </div><br>
  <div id="a3">
    <input type="submit" onclick="return check();" value="添加" id="i3" />
  </div>
</form>
</body>
</html>
