<%@ page import="com.tju.examsystem.domain.PaperGrade" %>
<%@ page import="java.util.List" %>
<%@ page import="com.tju.examsystem.domain.PaperGrade" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>已完成试卷</title>
<%--    <link rel="stylesheet" type="text/css" href="css/studentPaperGrade.css"/>--%>
    <style>
        #a1 {
            width: 30%;
            height: 90px;
            float: left;
        }

        #a2 {
            width: 55%;
            height: 40px;
            float: left;
            text-align: right;
            padding-top: 35px;
            z-index: 1;
        }

        #t1 {
            width: 100%;
            height: 500px;
        }

        #table {
            width: 100%;
            text-align: center;
            border-color: #6495ED;
            border: 0px solid #6495ED;
        }

        .table {
            width: 80%;
            float: left;
            height: 400px;
        }


        th {
            border: 1px solid ghostwhite;
        }

        th {
            height: 40px;
            background-color: #6495ED;
        }

        td {
            border: 1px solid floralwhite;
            height: 30px;
        }

        tr:hover {
            background-color: #999999;
            height: 37px;
        }

        #td {
            border: 3px solid #000000;
            width: 60px;
            height: 40px;
            background-color: #6495ED;
        }


        .a10 .ss1 {
            height: 40px;
            border: 2px solid #000000;
            border-radius: 3px 3px 3px 3px;
            width: 80px;
            margin-right: 40px;
            margin-left: 20px;
            font-size: 16px;
        }

        #xiu {
            border-radius: 3px 3px 3px 3px;
            border: 1px solid bisque;
            padding: 5px;
            box-shadow: 0px 0px 30px 0px #DCDCDC;
            background-color: coral;
        }

        #xiu:hover {
            color: #BD0A01;
        }

        #xiu2 {
            border-radius: 3px 3px 3px 3px;
            border: 1px solid bisque;
            padding: 5px;
            box-shadow: 0px 0px 30px 0px #DCDCDC;
            background-color: springgreen;
        }

        #xiu2:hover {
            color: #BD0A01;
        }


        /* #h2{width: 100%;float: left;height: 40px;border-radius: 0px 0px 50% 50%/0px 0px 30px 30px;background-color: #6495ED;} */
        #span1 {
            width: 20px;
            font-size: x-large;
            line-height: 10px;
        }
        #alldiv{
            overflow: auto;
        }

    </style>
</head>
<body>
<div id="a1">

</div>

</div>

<div class="table" id="alldiv">
    <table border="1" style="text-align:center" id="table" cellspacing="0">
        <tr>
            <th>编号</th>
            <th>试卷名称</th>
            <th>发布教师</th>
            <th>试卷成绩</th>
        </tr>
        <%
            List<PaperGrade> paperGrade= (List<PaperGrade>) request.getAttribute("paperGrade");
            int i=0;
            for(PaperGrade pg:paperGrade){
        %>
        <tr>
            <td><%=++i %></td>
            <td><%=pg.getTitle()%></td>
            <td><%=pg.getTeacherName()%></td>
            <td><%=pg.getGrade()%></td>
        </tr>
        <%
            }
        %>
    </table>
</div>

</body>
</html>
