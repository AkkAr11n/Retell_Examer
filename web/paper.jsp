<%@ page import="com.tju.examsystem.domain.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>考试界面</title>
    <style>
        /* styles.css */

        body, html {
            margin: 0;
            padding: 0;
            height: 100%;
        }

        .box_exam {
            display: flex;
            height: 100vh;
        }

        .box_left {
            flex: 0 0 50px; /* 固定左侧边栏宽度为 200px */
            background-color: lightblue;
            /* padding: 20px; */
        }

        .box_right {
            flex: 1; /* 填充剩余空间 */
            /* background-color: lightgreen; */
            /*background-image: url('/img/1.jpg');*/
            padding-bottom: 0px;
        }


        .my_font {
            font-size: 30px;
            font-weight: bold;
            height: 10vh;
            /* margin-bottom: 10px; */
            display: flex;
            align-items: center; /* 垂直方向居中 */
            justify-content: left; /* 水平方向居中 */
            margin-left: 3%;
            color: rgb(10, 227, 166); /* 设置字体颜色为深灰色，可以使用其他颜色值 */
        }


        .exam {
            align-items: center; /* 垂直方向居中 */
            justify-content: left; /* 水平方向居中 */
            margin-left: 3%;
            color: rgb(1, 1, 1);
        }

        .submit {
            align-items: center; /* 垂直方向居中 */
            justify-content: right; /* 水平方向居中 */
            margin-right: 3%;
        }

        .bottom {
            height: 90%;
            width: 100%;
            display: flex;
        }

        .problem_title {
            display: flex;
            width: 12%;
            background-color: grey;
            display: flex;
            flex-direction: column;
            /* height: 100%; */
        }
        .my_problem {
            height: 100%;
            width: 100%;
            background-color: lightyellow;
            /* padding: 20px; */
        }

        .my_title {
            display: flex;
            justify-content: space-between;
            width: 100%;
            height: 5%;
            background-color:lightyellow;
            font-size: 20px;
            /* padding: 10px; */
            /* margin-bottom: 10px; */
        }

        .problem_top {
            background-color: lightyellow;
            padding: 10px;
            margin-bottom: 10px;
        }

        .pro_tit {
            margin-left: 10px;
        }

        .problemTitle
        {
            margin-left: 30px;
        }
        .tit {
            margin-left: 50px;
        }
        .problem {
            height: 92%;
            /*background-image: url('/img/2.jpg');*/
            background-size: cover; /* 将背景图片调整为覆盖整个容器 */
            /* background-color: lightpink; */
            padding: 10px;
            /* padding-left: 100px; */
            overflow: auto;
        }

        .choseAnswer {
            display: flex;
            flex-direction: column;

        }

        .problemTitle{
            font-size: 25px;
        }

        .judgeTitle {
            font-size: 30px;
        }

        .inputTitle{
            font-size: 30px;
        }

        .chose
        .pro_tit
        {
            margin-top: 1px;
        }
        .pro_tit{
            margin-bottom: 10px;
            margin-top: 10px;
            font-size: 30px;
        }

        .tit {
            margin-top: 6px;
            margin-bottom: 5px;
        }

        .dh {
            height: 10%;
            width: 70%;;
        }

        input[type="text"] {
            height: 30px;
        }

    </style>
</head>

<body>
<div class="box_exam">
    <div class="box_left"></div>
    <div class="box_right">
        <div class="my_font">在线考试管理系统</div>
        <div class="bottom">
            <div class="problem_title">
                <div class="dh"> 一、单选 </div>
                <div class="dh"> 二、多选 </div>
                <div class="dh"> 三、判断 </div>
                <div class="dh"> 四、填空 </div>
            </div>

            <div class="my_problem">
                <div class="my_title">
                    <div class="exam">数据库考试</div>

                </div>

                <!-- <div class="problem_top">我是数据库考试</div> -->

                <div class="problem">
                    <div class="chose">
                        <div class="pro_tit">一、单选题</div>
                        <div>
                            <%
                                List<Question>singles= (List<Question>) request.getAttribute("singles");
                                int i=0;
                                for(Question single:singles){
                            %>
                            <div class="problemTitle"><%=++i%>、<%=single.getTitle()%></div>
                            <div class="choseAnswer">
                                <%
                                    String content = single.getContent();
                                    int j=0;
                                    char ch[]={' ','A','B','C','D'};
                                    for(String opt:content.split("#")){
                                %>
                                <div class="tit"> <input type="radio" disabled ><%=ch[++j]%>: <%=opt%> </div>
                                <%
                                    }
                                %>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <div class="many_chose">
                        <div class="pro_tit">二、多选题</div>
                        <div>
                            <%
                                List<Question>multiples= (List<Question>) request.getAttribute("multiples");
                                i=0;
                                for(Question multiple:multiples){
                            %>
                            <div class="problemTitle"><%=++i%>、<%=multiple.getTitle()%></div>
                            <div class="choseAnswer">
                                <%
                                    String content = multiple.getContent();
                                    int j=0;
                                    char ch[]={' ','A','B','C','D'};
                                    for(String opt:content.split("#")){
                                %>
                                <div class="tit"> <input type="checkbox" disabled><%=ch[j]%>: <%=opt%></div>
                                <%
                                    }
                                %>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>

                    <div class="judge">
                        <div class="pro_tit">三、判断题</div>
                        <div>
                            <%
                                List<Question> estimates= (List<Question>) request.getAttribute("estimates");
                                i=0;
                                for(Question estimate:estimates){
                            %>
                            <div class="problemTitle"><%=++i%>、<%=estimate.getTitle()%></div>
                            <div class="choseAnswer">
                                <div class="tit"> <input type="radio" disabled name="judge<%=i%>">T </div>
                                <div class="tit"> <input type="radio"  disabled name="judge<%=i%>">F </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>

                    <div class="input">
                        <div class="pro_tit">四、填空题</div>

                        <div>
                            <%
                                List<Question> fills= (List<Question>) request.getAttribute("fills");
                                i=0;
                                for(Question fill:fills){
                            %>
                            <div class="problemTitle"><%=++i%>、<%=fill.getTitle()%></div>
                            <div class="tit">
                                <input type="text" name="blank1" placeholder="空1">
                                <input type="text" name="blank2" placeholder="空2">
                                <input type="text" name="blank3" placeholder="空3">
                                <input type="text" name="blank4" placeholder="空4">
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>

                </div>
            </div>
        </div>


    </div>

</div>
</body>

</html>