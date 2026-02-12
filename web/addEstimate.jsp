
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" http-equiv="Page-Enter" content="RevealTrans(duration=5,Transtionv=2)">
    <title>添加判断题</title>
    <style type="text/css">
        #a1{width: 100%;height: 360px;float: left;}
        #a2{width: 60%;height: 360px;float: left;}
        #a3{width: 40%;height: 100px;float: left;text-align: center;}
        label{font-size: x-large;}
        #i1{width: 210px;height: 30px; border-radius: 7px 7px 7px 7px;}
        #i2{zoom: 2;}
        option{height: 20px;}
        #i3{width: 180px;background-color: #6495ED;height: 50px;margin-left: 10%;font-size: x-large;float: left;}
    </style>
</head>
<body>
<h2>~~添加判断题~~</h2>
<form action="<%=request.getContextPath()%>/question/addEstimate" method="post">
    <div id="a1">
        <label>题目内容</label><br>
        <textarea name="title" cols="130" rows="6"></textarea><br><br>
        <label><td>请选择正确答案</td></label>
        <td>
            <input type="radio" name="answer" value="T" id="zhengque">
            <label for="zhengque">对</label>
            <input type="radio" name="answer" value="F" id="cuowu">
            <label for="cuowu">错</label>
        </td><br><br>
        <label><td>请选择题目难度</td></label>
        <td>
            <input type="radio" name="difficulty" value="0" id="jiandan">
            <label for="jiandan">简单</label>
            <input type="radio" name="difficulty" value="1" id="zhongdeng">
            <label for="zhongdeng">中等</label>
            <input type="radio" name="difficulty" value="2" id="kunnan">
            <label for="kunnan">困难</label>
        </td><br><br>
        <input type="submit" value="添加" id="i3" />
</form>
</body>
</html>