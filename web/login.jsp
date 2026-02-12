
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登陆界面</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css?t=11"/>
    <script type="text/javascript" src="/js/login.js?t=21"></script>
</head>
<body >
<div class="container">
    <div class="login-wrapper">
        <div class="header">欢迎使用在线考试系统</div>
        <div class="form-wrapper">
            <form id="userForm" action="<%=request.getContextPath()%>/user/login" method="post" >
                <input type="text" id="username" name="username" placeholder="用户名" class="input-item">
                <input type="text"  id="confirmUsername" placeholder="确认用户名" class="input-item">
                <input type="text"  id="checkCode" placeholder="验证码" class="input-item">
                <span><img src="checkCode" alt="" onclick="changeCheckCode(this)"></span>
                <script type="text/javascript">
                    //图片点击事件
                    function changeCheckCode(img) {
                        img.src="checkCode?"+new Date().getTime();

                    }
                </script>
                <div>
                    <input type="radio" id="contactChoice1" name="permission" value='0' checked/>
                    <label for="contactChoice1">学生</label>
                    <input type="radio" id="contactChoice2" name="permission" value='1' />
                    <label for="contactChoice2">教师</label>
                    <input type="radio" id="contactChoice3" name="permission" value='2' />
                    <label for="contactChoice3">管理员</label>
                </div>
                <input type="button" id="lgBtn" class="btn" value="登录">
            </form>
        </div>
    </div>
</div>
</body>
</html>
