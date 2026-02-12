
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>welcome学生信息管理系统</title>
    <style type="text/css">
        *{margin: 0;padding: 0;}
        #a1 {
            width: 80%;
            height: 70px;
            padding-left: 23px;
            padding-top: 20px;
            margin-bottom: 10px;
            margin-top: 5px;
            box-shadow: 0px 0px 1500px 0px #DDDDDD;
            float: left;
            z-index: 1;
        }
        .top{
            /* background: linear-gradient(to right,#6495ED,mistyrose);
                   -webkit-background-clip: text;
                   color: transparent; */
            color: #6495ED;
        }
        #a2{width: 18%;height: 70px;float: left;margin-bottom: 10px;padding-top: 20px;
            margin-top: 5px;box-shadow: 0px 0px 1500px 0px #DDDDDD;z-index: 1;}
        #aa1,#aa2{width: 35%;height: 45px;float: left;margin-right: 10px;
            border-radius: 5px 5px 5px 5px;box-shadow: 0px 0px 20px 0px #DCDCDC;}
        #aa2 a,#aa1 a{font-size: larger;width: 100%;height: 42px;color: #6495ED;line-height: 42px;
            text-decoration: none;}
        #aa1 a:hover{color: #BD0A01;}
        #aa2 a:hover{color: #BD0A01;}
        #tab1{float: left;width: 220px;height: 550px;text-align: left;margin-top: 0px;border: 1px solid #6495ED;background:#6495ED;margin-left: 5px;box-shadow: 0px 0px 35px 0px #DDDDDD;}
        #tab2{float: left;width: 100%;height: 170px;text-align: center;border-bottom: 1px solid #000000;color: #DDDDDD;}
        #t2{height: 150px;width: 100%;}
        #t2 tr th{height: 30px;font-size: x-large;}
        img{border:0;}
        #img1{margin-top: 5px;border-radius: 50%;}
        ul,li{list-style-type:none;}
        a{color:#6495ED;text-decoration:none;}
        a:hover {color:#bd0a01;text-decoration:underline;}
        .boxmsg{width: 130px; height: 10px;}
        .treebox{ width: 100%; margin: 0px auto; background-color: #6495ED;}
        .menu{ overflow: hidden; border-color: #ddd; border-style: solid ; border-width: 0 1px 1px ; }
        /*第一层*/
        .menu li.level1>a{
            display:block;
            height: 47px;
            line-height: 47px;
            color: white;
            padding-left: 50px;
            border-bottom: 1px solid #000;
            font-size: 15px;
            position: relative;
            transition:all .5s ease 0s;
        }
        #mg{height: 100px;background-color: #6495ED;text-align: center;width: 200px;}
        .menu li.level1 a:hover{ text-decoration: none;background:-webkit-linear-gradient(left,#6495ED,mistyrose);/* border: 2px solid #000000; */}
        .menu li.level1 a.current{background:-webkit-linear-gradient(top,#6495ED,pink);}

        /*============修饰图标*/
        .ico{ width: 20px; height: 20px; display:block;   position: absolute; left: 20px; top: 13px; background-repeat: no-repeat; background-image: url(../images/ico1.png); }

        /*============小箭头*/
        .level1 i{ width: 20px; height: 10px; background-image:url(../images/arrow.png); background-repeat: no-repeat; display: block; position: absolute; right: 20px; top: 20px; }
        .level1 i.down{ background-position: 0 -10px; }

        .ico1{ background-position: 0 0; }
        .ico2{ background-position: 0 -20px; }
        .ico3{ background-position: 0 -40px; }
        .ico4{ background-position: 0 -60px; }
        .ico5{ background-position: 0 -80px; }

        /*第二层*/
        .menu li ul{ overflow: hidden; }
        #xinxi{visibility: visible;}
        .menu li ul.level2{ display: none;background: #6495ED; }
        .menu li ul.level2 li a{
            display: block;
            height: 45px;
            line-height: 45px;
            color: white;
            text-indent: 60px;
            /*border-bottom: 1px solid #ddd; */
            font-size: 17px;
            transition:all 1s ease 0s;
        }
        #zhu{width: 80%;height: 550px;float: left;margin-left: 5px; box-shadow: 0px 0px 35px 0px #DDDDDD;z-index: 0;}
    </style>
</head>
<body>
<div id="a1">

    <font size="6"><b><span class="top">&nbsp;在线考试管理系统</span></b></font>

</div>
<div id="a2">
    <div>
        <form action="<%=request.getContextPath()%>/upload?permission=0" method="post" enctype="multipart/form-data">
            <input type="file" name="photo">
            <br>
            <input type="submit" value="更换头像">
        </form>
    </div>

</div>
<div id="tab1">
    <div id="tab2">
        <table border="0" cellspacing="0" cellpadding="0" id="t2">
            <tr><th>学&nbsp;生&nbsp;信&nbsp;息</th></tr>
            <tr><td ><img src="<%=request.getAttribute("img")%>" width="100px" height="100px" id="img1"></td></tr>
            <tr><td height="30px"><%= session.getAttribute("studentId") %></td></tr>
        </table>
    </div>
    <div class="treebox">
        <ul class="menu">
            <li class="level1">
                <a href="<%=request.getContextPath()%>/student/paper/info" target="yem"><em class="ico ico2"></em>未完成试卷<i></i></a>
            </li>
            <li class="level1">
                <a href="<%=request.getContextPath()%>/student/paper/grade" target="yem"><em class="ico ico3"></em>已完成试卷<i></i></a>
            </li>
        </ul>
    </div>
</div>
<div id="zhu">
    <iframe src="<%=request.getContextPath()%>/student/paper/info" width="100%" height="550px" name="yem" border="0" scrolling="no" frameborder="0"></iframe>
</div>




</body>
</html>
