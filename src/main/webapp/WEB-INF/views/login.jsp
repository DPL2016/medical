<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/medical/css/style.css">
</head>
<body>
<div class="container">

    <c:if test="${not empty message}">
        <c:choose>
            <c:when test="${message.state=='success'}">
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${message.message}
                </div>
            </c:when>
            <c:otherwise>
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                        ${message.message}
                </div>
            </c:otherwise>
        </c:choose>
    </c:if>
    <div class="login_warper">
        <form id="login" action="/" method="post">
            <legend>KaiShengIT</legend>
            <label>账号</label>
            <input type="text" name="username">
            <label>密码</label>
            <input type="password" name="password"><br><br>
            <div class="form-actions">
                <button id="submit" class="button button-flat-action">进入系统</button>
            </div>
        </form>
    </div>

</div>
<script src="/static/jQuery/jquery-2.2.3.min.js"></script>
<script src="/static/bootstrap/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#submit").click(function(){
            $("#login").submit();
        });
    });
</script>

</body>
</html>
