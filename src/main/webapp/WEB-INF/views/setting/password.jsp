<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/medical/css/style.css">
</head>
<body>
<jsp:include page="../include/nav.jsp">
    <jsp:param name="menu" value="setting"/>
</jsp:include>

            <div class="content">

                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">设置密码</h3>
                    </div>
                    <div class="box-body">
                        <form method="post" id="changePasswordForm">
                            <div class="form-group">
                                <label>旧密码</label>
                                <input type="password" class="form-control" name="oldpassword">
                            </div>
                            <div class="form-group">
                                <label>新密码</label>
                                <input type="password" class="form-control" name="newpassword" id="newpassword">
                            </div>
                            <div class="form-group">
                                <label>确认密码</label>
                                <input type="password" class="form-control" name="replypassword">
                            </div>
                        </form>
                    </div>
                    <div class="box-footer">
                        <button id="saveBtn" class="btn btn-primary pull-right">保存</button>
                    </div>
                </div>

            </div>

<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>

<script>
    $(function(){

        $("#changePasswordForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                oldpassword:{
                    required:true,
                    remote:"/user/validate/password"
                },
                newpassword:{
                    required:true,
                    rangelength:[6,18]
                },
                replypassword:{
                    required:true,
                    rangelength:[6,18],
                    equalTo:"#newpassword"
                }
            },
            messages:{
                oldpassword:{
                    required:"请输入旧密码",
                    remote:"旧密码错误"
                },
                newpassword:{
                    required:"请输入新密码",
                    rangelength:"密码长度6~18位"
                },
                replypassword:{
                    required:"请输入确认密码",
                    rangelength:"密码长度6~18位",
                    equalTo:"两次密码不一致"
                }
            },
            submitHandler:function(form){
                var password = $("#newpassword").val();
                $.post("/user/password",{"password":password}).done(function(data){
                    if(data == 'success') {
                        alert("密码修改成功，点击确定重新登录");
                        window.location.href = "/";
                    }
                }).fail(function(){
                    alert("服务器异常");
                });
            }
        });


        $("#saveBtn").click(function(){
            $("#changePasswordForm").submit();
        });
    });
</script>



</body>
</html>