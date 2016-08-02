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

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">


            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">登录日志列表</h3>
                </div>
                <div class="box-body">
                    <table class="table table-bordered table-hover" id="logTable">
                        <thead>
                        <tr>
                            <th>登录时间</th>
                            <th>登录IP</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>


        </div>
    </div>
</div>

</body>
</html>