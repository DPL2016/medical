
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="http://cdn.staticfile.org/twitter-bootstrap/2.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="http://cdn.staticfile.org/font-awesome/4.1.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/medical/css/style.css">
</head>
<body>
<jsp:include page="../../include/nav.jsp">
    <jsp:param name="menu" value="settings"/>
</jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <div class="box">
                <div class="box-header">
            <span class="title">
              <i class="fa fa-plus"></i>
              <a href="/account"> 系统账户列表</a>  /  新增账号
            </span>
                </div>
                <div class="box-body form">
                    <form id="newForm">
                        <label>员工姓名</label>
                        <input type="text" id="name" name="realname">
                        <label>账号 <span class="muted">(用于登录系统)</span></label>
                        <input type="text" id="account" name="username">
                        <label>密码 <span class="muted">(默认123456)</span></label>
                        <input type="password" value="123456" name="password">
                        <label>联系电话</label>
                        <input type="text" name="tel">
                        <label>请选择角色</label>
                        <select name="role.id">
                            <option value="1">管理员</option>
                            <option value="2">员工</option>
                        </select>

                        <div class="form-actions">
                            <button id="saveBtn" class="button button-flat-action button-pill">保存</button>
                        </div>
                    </form>
                </div>
            </div>


        </div>

    </div>
</div>



<script src="http://cdn.staticfile.org/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/twitter-bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="/static/plugins/validate/jquery.validate.min.js"></script>
<script>

    $(function(){

        $("#newForm").validate({
            errorClass:"text-danger",
            errorElement:"span",
            rules:{
                username:{
                    required:true,
                    rangelength:[3,20],
                },
                realname:{
                    required:true,
                    rangelength:[2,20]
                },
                password:{
                    required:true,
                    rangelength:[6,18]
                },
                tel:{
                    required:true
                }
            },
            messages:{
                username:{
                    required:"请输入用户名",
                    rangelength:"用户名的长度3~20位",
                    remote:"该用户名已被占用"
                },
                realname:{
                    required:"请输入真实姓名",
                    rangelength:"真实姓名长度2~20位"
                },
                password:{
                    required:"请输入密码",
                    rangelength:"密码长度6~18位"
                },
                tel:{
                    required:"请输入电话",
                }
            },
            submitHandler:function(form){
                $.post("/account/new",$(form).serialize()).done(function(data){
                    window.location.href = '/account';
                }).fail(function(){
                    alert("服务器异常")
                });
            }
        });
        $("#saveBtn").click(function(){
            $("#newForm").submit;
        });
    });
</script>

</body>
</html>