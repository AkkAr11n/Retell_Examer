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
        body,html {
            margin: 0;
            padding: 0;
            height: 100%;
        }

        .box_exam {
            display: flex;
            height: 100vh;
        }

        .box_left {
            flex: 0 0 50px;
            /* 固定左侧边栏宽度为 200px */
            background-color: lightblue;
            /* padding: 20px; */
        }

        .box_right {
            flex: 1;
            /* 填充剩余空间 */
            /* background-color: lightgreen; */
            background-image: url('/img/1.jpg');
            padding-bottom: 0px;
        }


        .my_font {
            font-size: 30px;
            font-weight: bold;
            height: 10vh;
            /* margin-bottom: 10px; */
            display: flex;
            align-items: center;
            /* 垂直方向居中 */
            justify-content: left;
            /* 水平方向居中 */
            margin-left: 3%;
            color: rgb(10, 227, 166);
            /* 设置字体颜色为深灰色，可以使用其他颜色值 */
        }

        .bottom {
            height: 90%;
            width: 100%;
            display: flex;
        }

        .my_publish {
            height: 100%;
            width: 100%;
            background-color: lightyellow;
            /* padding: 20px; */
        }

        .exam {
            align-items: center;
            /* 垂直方向居中 */
            justify-content: left;
            /* 水平方向居中 */
            margin-left: 3%;
            color: rgb(1, 1, 1);
        }

        .submit {
            align-items: center;
            /* 垂直方向居中 */
            justify-content: right;
            /* 水平方向居中 */
            margin-right: 3%;
        }

        .my_title {
            display: flex;
            justify-content: space-between;
            width: 100%;
            height: 5%;
            background-color: lightyellow;
            font-size: 20px;
            /* padding: 10px; */
            /* margin-bottom: 10px; */
        }

        .exam_publish {
            margin-top: 10px;
            margin-left: 10px;
        }

        .publish {
            height: 92%;
            background-image: url('/img/2.jpg');
            background-size: cover;
            /* 将背景图片调整为覆盖整个容器 */
            /* background-color: lightpink; */
            padding: 10px;
            /* padding-left: 100px; */
            display: flex;
            align-items: center;
            justify-content: center;
            /* overflow: auto; */
        }

        .publish_information {
            height: 90%;
            width: 70%;
            /* background-color: aqua; */
        }

        .publish_title {
            font-size: 50px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }

        .publish_form {
            font-size: 30px;
            margin-left: 30px;
            margin-top: 20px;
        }

        .chose_form {
            margin-top: 20px;
        }

        .content {
            margin-top: 20px;
        }


        .content {
            display: flex;
            align-items: center;
            /* 在交叉轴上居中对齐，即垂直方向上对齐 */
        }

        .content label {
            margin-right: 15px;
            /* 为了增加标签和输入框之间的间距 */
        }

        .content input[type="text"] {
            width: 200px;
            /* 设置文本输入框宽度，可以根据需要调整 */
            height: 30px;
            /* 设置文本输入框高度，可以根据需要调整 */
        }

        .content input[type="datetime-local"] {
            width: 200px;
            /* 设置文本输入框宽度，可以根据需要调整 */
            height: 30px;
            /* 设置文本输入框高度，可以根据需要调整 */
        }

        .my_content {
            margin-top: 20px;
            /* display: flex; */
            /* 将容器设置为 Flexbox 布局 */
            /* flex-wrap: wrap; */
            /* 允许换行 */
        }

        .option {
            padding: 10px;
            border-bottom: 1px solid #ccc;
            cursor: pointer;
            flex: 0 0 33.33%;
            box-sizing: border-box;
            display: flex;
            align-items: center;
            flex-wrap: wrap;
            display: none;
        }

        .option input {
            margin-right: 5px;
            /* 可以根据需要调整 checkbox 和 label 之间的间距 */
        }

        .option label {
            margin-right: 5px;
            /* 可以根据需要调整 label 之间的间距 */
        }

        .option:last-child {
            border-bottom: none;
        }


        .option:last-child {
            border-bottom: none;
        }


        .my_button {
            margin-top: 30px;
        }

        button {
            padding: 10px 20px;
            /* 设置按钮内边距，可以根据需要调整 */
            background-color: #f5ac0e;
            /* 设置按钮背景颜色 */
            color: white;
            /* 设置按钮文字颜色 */
            border: none;
            /* 去除按钮边框 */
            border-radius: 4px;
            /* 设置按钮圆角 */
            cursor: pointer;
            /* 添加鼠标悬停效果 */

            display: block;
            /* 将按钮设置为块级元素 */
            margin: auto;
            /* 在 Flex 容器中通过 margin: auto; 实现水平居中 */
        }

        button:hover {
            background-color: #6fa70e;
            /* 设置按钮悬停时的背景颜色 */
        }
    </style>
    <script>
       window.onload=function (){
           const selectTrigger = document.querySelector('.select-trigger');
           const optionsContainer = document.querySelector('.option');

           selectTrigger.addEventListener('click', () => {
               optionsContainer.style.display = optionsContainer.style.display === 'none' ? 'block' : 'none';
           });
       }

    </script>

</head>

<body>
<div class="box_exam">
    <div class="box_left"></div>
    <div class="box_right">
        <div class="my_font">在线考试管理系统</div>
        <div class="bottom">
            <div class="my_publish">
                <div class="my_title">
                    <div class="exam_publish">试卷发布</div>
                </div>
                <div class="publish">
                    <div class="publish_information">
                        <div class="publish_title">考试</div>

                        <div class="publish_form" id="exam-form">
                            <div class="my_content">
                                <div class="select-trigger">
                                    <span>选择发布班级:</span>
                                    <span>&#x25BC;</span>
                                </div>
                            <form action="<%=request.getContextPath()%>/paper/publishPaper" method="post">
                                <div class="option">
                                    <input type="text" name="paperId" style="display:none" value="<%=request.getAttribute("paperId")%>" readonly/>
                                    <%

                                        List<String> squads= (List<String>) request.getAttribute("squads");
                                        int i=0;
                                        for(String squad :squads){
                                    %>
                                    <input type="checkbox" id="class<%=++i%>" name="squad" value="<%=squad%>">
                                    <label for="class<%=i%>"><%=squad%></label>
                                    <%
                                        }
                                    %>
                                </div>

                                <div class="content">
                                    <label for="exam-start">考试开始时间:</label>
                                    <input type="datetime-local" step="1" id="exam-start" name="startTime" required>
                                </div>

                                <div class="content">
                                    <label for="exam-end">考试结束时间:</label>
                                    <input type="datetime-local" step="1" id="exam-end" name="endTime" required>
                                </div>

                                <div class="my_button"> <input type="submit" value="发布试卷">
                                </div>
                            </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>


</html>