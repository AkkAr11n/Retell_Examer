<%@ page import="com.tju.examsystem.domain.Question" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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



    <title>考试界面</title>
</head>

<body>






<script type="text/javascript">
    var arr = new Array(); // 使用 [] 来创建数组
    //
    var paperId='<%=request.getAttribute("paperId")%>'
    var singleMark=<%=request.getAttribute("singleMark")%>;
    var multipleMark=<%=request.getAttribute("multipleMark")%>;
    var estimateMark=<%=request.getAttribute("estimateMark")%>;
    var fillMark=<%=request.getAttribute("fillMark")%>;
    <%
    List<Question> singles = (List<Question>) request.getAttribute("singles");
    for (Question single : singles) {
    %>
    arr.push('<%= single.getAnswer() %>'); // 将单个选择题答案添加到 JavaScript 数组中

    <%
    }
    %>
    var singleCnt=<%=singles.size()%>;


    <%
        List<Question>multiples= (List<Question>) request.getAttribute("multiples");
        for(Question multiple:multiples){
    %>
    arr.push('<%= multiple.getAnswer() %>'); // 将单个选择题答案添加到 JavaScript 数组中
    <%
    }
    %>
    var multipleCnt=<%=multiples.size()%>;



    <%
       List<Question>estimates= (List<Question>) request.getAttribute("estimates");
       for(Question estimate:estimates){
   %>
    arr.push('<%= estimate.getAnswer() %>'); // 将单个选择题答案添加到 JavaScript 数组中
    <%
    }
    %>
    var estimateCnt=<%=estimates.size()%>;


    <%
       List<Question>fills= (List<Question>) request.getAttribute("fills");
       for(Question fill:fills){
   %>
    arr.push('<%= fill.getAnswer() %>'); // 将单个选择题答案添加到 JavaScript 数组中
    <%
    }
    %>
    var fillCnt=<%=fills.size()%>;
    // console.log(singleMark);
    // console.log(multipleMark);
    // console.log(estimateMark);
    // console.log(fillMark);
    // console.log("hh");
    // console.log(arr);
    window.onload=function (){
        // 设置初始时间（2小时）
        let initialTime = Number(<%=request.getAttribute("seconds")%>);
        let currentTime = initialTime;
        let countdownInterval;

        // 获取显示倒计时的元素


        // 更新倒计时的函数
        function updateTimer() {
            let timerElement = document.getElementById('timer');
            let hours = Math.floor(currentTime / 3600);
            let minutes = Math.floor((currentTime % 3600) / 60);
            let seconds = currentTime % 60;

            // 将时间格式化为 hh:mm:ss
            let formattedTime = ('0' + hours).slice(-2) + ':' + ('0' + minutes).slice(-2) + ':' + ('0' + seconds).slice(-2);

            // 更新页面上显示的时间
            timerElement.textContent = formattedTime;
        }

        // 开始倒计时
        function startCountdown() {
            // 每秒更新一次倒计时
            countdownInterval = setInterval(function () {
                currentTime--;

                // 更新倒计时显示
                updateTimer();

                // 如果时间为0，清除定时器
                if (currentTime <= 0) {
                    clearInterval(countdownInterval);
                    alert('考试时间结束, 已自动交卷！');
                }
            }, 1000);
        }

        // 提交考试
        function submitExam() {
            clearInterval(countdownInterval);

            alert('你已提前交卷！');
        }
        startCountdown();



        document.getElementById("sub").onclick = function(){
            let sum=0;
            for(let i=1;i<=singleCnt;i++){
                let radios= document.getElementsByName("choose"+i);
                for(let j=0;j<radios.length;j++)
                    if(radios[j].checked){
                        if(arr[i-1]==radios[j].value) sum+=singleMark;
                        // console.log(radios[j].value);
                    }
            }
            for(let i=1;i<=multipleCnt;i++){
                let checkbox= document.getElementsByName("mchoose"+i);
                let str="";
                for(let j=0;j<checkbox.length;j++)
                    if(checkbox[j].checked){
                        str+=checkbox[j].value;
                    }
                if(arr[i-1+singleCnt]==str) sum+=multipleMark;
            }
            for(let i=1;i<=estimateCnt;i++){
                let radios= document.getElementsByName("judge"+i);
                for(let j=0;j<radios.length;j++)
                    if(radios[j].checked){
                        if(arr[i-1+singleCnt+multipleCnt]==radios[j].value) sum+=estimateMark;
                    }
            }
            for(let i=1;i<=fillCnt;i++){
                let answers=new Array();
                answers.push(document.getElementById("blank1"+i).value);
                answers.push(document.getElementById("blank2"+i).value);
                answers.push(document.getElementById("blank3"+i).value);
                answers.push(document.getElementById("blank4"+i).value);
                let s="";
                for(let j=0;j<answers.length;j++){
                    let str=answers[j];
                    if(str==null||str==""){
                        str=" ";
                    }
                    if(j!=0) s+="#";
                    s+=str;
                }
                if(arr[i-1+singleCnt+multipleCnt+estimateCnt]==s) sum+=fillMark;
            }
            document.location.href="<%= request.getContextPath()%>/student/addGrade?paperId="+paperId+"&grade="+sum;
        }
    }
</script>
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
                    <div id="countdown">考试剩余时间: <span id="timer">  </span></div>
                    <button class="submit" id="sub">交卷</button>
                </div>


                <div class="problem">
                    <div class="chose">
                        <div class="pro_tit">一、单选题(每题<%=request.getAttribute("singleMark")%>分)</div>
                        <div>
                            <%
//                                List<Question>singles= (List<Question>) request.getAttribute("singles");
                                singles= (List<Question>) request.getAttribute("singles");
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
                                <div class="tit"> <input type="radio"  value="<%=ch[++j]%>" name="choose<%=i%>"><%=ch[j]%>: <%=opt%> </div>
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
                        <div class="pro_tit">二、多选题(每题<%=request.getAttribute("multipleMark")%>分)</div>
                        <div>
                            <%
//                                List<Question>multiples= (List<Question>) request.getAttribute("multiples");
                                multiples= (List<Question>) request.getAttribute("multiples");
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
                                <div class="tit"> <input type="checkbox" value="<%=ch[++j]%>" name="mchoose<%=i%>"><%=ch[j]%>: <%=opt%></div>
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
                        <div class="pro_tit">三、判断题(每题<%=request.getAttribute("estimateMark")%>分)</div>
                        <div>
                            <%
                                estimates= (List<Question>) request.getAttribute("estimates");
                                i=0;
                                for(Question estimate:estimates){
                            %>
                            <div class="problemTitle"><%=++i%>、<%=estimate.getTitle()%></div>
                            <div class="choseAnswer">
                                <div class="tit"> <input type="radio" name="judge<%=i%>" value="T">T </div>
                                <div class="tit"> <input type="radio" name="judge<%=i%>" value="F">F </div>
                            </div>
                            <%
                                }
                            %>
                        </div>
                    </div>

                    <div class="input">
                        <div class="pro_tit">四、填空题(每题<%=request.getAttribute("fillMark")%>分)</div>

                        <div>
                            <%
                               fills= (List<Question>) request.getAttribute("fills");
                                i=0;
                                for(Question fill:fills){
                            %>
                            <div class="problemTitle"><%=++i%>、<%=fill.getTitle()%></div>
                            <div class="tit">
                                <input type="text" id="blank1<%=i%>"  placeholder="空1">
                                <input type="text" id="blank2<%=i%>"  placeholder="空2">
                                <input type="text" id="blank3<%=i%>"  placeholder="空3">
                                <input type="text" id="blank4<%=i%>"  placeholder="空4">
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