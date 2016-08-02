
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar navbar-static-top">
    <div class="navbar-inner" style="margin-bottom: 50px">
        <a class="brand" href="#">凯盛医疗</a>
        <ul class="nav">
            <li class="${param.menu =='home'?'active':''}"><a href="/home"><i class="fa fa-home"></i> 首页</a></li>
            <li class="${param.menu == 'patient' ? 'active' : ''}"><a href="/patient"><i class="fa fa-building"></i> 病人档案</a></li>
            <li><a href="#"><i class="fa fa-stethoscope"></i>  就诊记录</a></li>
            <li><a href="#"><i class="fa fa-bell-o"></i> 复诊提醒</a></li>
            <li><a href="#"><i class="fa fa-bar-chart-o"></i> 数据统计</a></li>
            <li class="dropdown ${param.menu == 'settings' ? 'active' : ''}">
                <a href="" class="dropdown-toggle" data-toggle="dropdown" ><i class="fa fa-cogs"></i> 系统设置 <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li><a href=""><i class="fa fa-sitemap"></i> 科室设置</a></li>
                    <li><a href=""><i class="fa fa-medkit"></i> 病种设置</a></li>
                    <li><a href=""><i class="fa fa-bars"></i> 医保类型设置</a></li>
                    <li><a href=""><i class="fa fa-child"></i> 患者状态设置</a></li>
                    <li class="divider"></li>
                    <li><a href="/account"><i class="fa fa-user-md"></i> 账号设置</a></li>
                </ul>
            </li>
        </ul>
        <div class="dropdown pull-right ">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" ><i class="fa fa-cog"></i> 个人设置 <b class="caret"></b></a>
            <%--<span class="caret"></span>--%>
            </button>
            <ul class="dropdown-menu " aria-labelledby="dropdownMenu1">
                <li><a href="/user/password"><i class="fa fa-edit"></i>  修改密码</a></li>
                <li><a href="/user/log"><i class="fa fa-list-alt"></i>  登录日志</a></li>
                <li class="divider"></li>
                <li><a href="/logout"><i class="fa fa-sign-out"></i>  安全退出</a></li>
            </ul>
        </div>
    </div>
</div>