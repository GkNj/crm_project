<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>编辑联系人-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<SCRIPT language=javascript>
    function go()
    {
        window.history.go(-1);
    }
</SCRIPT>

<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;编辑交往信息
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">
            <form action="/trade.do?method=update&c_id=${requestScope.c_id}" method="post">
            <div class="baTopNo">
                <span>客户信息编辑</span>
            </div>
            <div class="baBody">
                <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;编号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="t_id" value="${requestScope.t_id}" readonly unselectable="on"/>
                </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="t_time" value="${requestScope.trade.t_time}"/>

            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地点：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="t_address" value="${requestScope.trade.t_address}"/>
            </div>

            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;细节：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="t_detail" value="${requestScope.trade.t_detail}"/>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;概要：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="t_outline" value="${requestScope.trade.t_outline}"/>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="t_remark" value="${requestScope.trade.t_remark}"/>
            </div>

            <div class="bbD">
                <p class="bbDP">
                    <!--保存暂时有问题-->
                    <input type="submit" name="Submit" value="保存" class="btn_ok btn_yes" />
                    <input type="button" class="btn_ok btn_no" name="Submit" onclick="javascript:history.back(-1);" value="返回">

                    <%--<a class="btn_ok btn_no" href="/communication.jsp">返回</a>--%>
                </p>
            </div>
        </div>
            </form>
    </div>
        <!-- 上传广告页面样式end -->
    </div>
</div>
<%--<form action="customer.do?method=update&cId=0">--%>
    <%--<input type="submit" value="vbaoqun"/>--%>
<%--</form>--%>
</body>
</html>