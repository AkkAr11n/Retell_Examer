window.onload = function(){
    document.getElementById("lgBtn").onclick = function () {
        const username=document.getElementById("username").value;
        const confirmUsername=document.getElementById("confirmUsername").value;
        if(username==confirmUsername){
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function () {
                if (this.readyState == 4) {
                    if (this.status == 200) {
                        if(this.responseText=="success"){
                            var formObj = document.getElementById("userForm");
                            formObj.submit();
                        }else alert(this.responseText);
                    } else {
                        alert(this.status)
                    }
                }
            }
            xhr.open("post", "/exam/user/verify", true)
            const username=document.getElementById("username").value;
            var rad = document.getElementsByName("permission");
            var permission;
            for (var i = 0; i < rad.length; i++) {
                if (rad[i].checked) {
                    permission = rad[i].value;
                    break;
                }
            }
            const checkCode=document.getElementById("checkCode").value;
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
            xhr.send("username=" + username + "&permission=" + permission + "&checkCode=" + checkCode);
        }else{
            alert("两次输入的用户名不一致！！");
        }

    }
}