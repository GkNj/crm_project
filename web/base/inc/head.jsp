<%--
  Created by IntelliJ IDEA.
  entity: dell
  Date: 2018/8/13
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>头部-有点</title>
    <link rel="stylesheet" type="text/css" href="../css/public.css" />
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
</head>

<body>
<!-- 头部 -->
<div class="head">
    <div class="headL">
        <img class="headLogo" src="../img/headLogo.png" />
    </div>
    <div class="headR">
        <p class="p1">
            欢迎，
            ${sessionScope.login_name}
        </p>
        <p class="p2">
        <form target="_top" action="/views/log.jsp">
        <button type="submit" style=";
    width: 50px;
    height: 30px;
    border: none;
    font-size: 14px;
    color: #fff;
    background-color: #47a4e1;">退出</button>
    </form>
        </p>
    </div>
    <!-- onclick="{if(confirm(&quot;确定退出吗&quot;)){return true;}return false;}" -->
</div>

<div class="closeOut">
    <div class="coDiv">
        <p class="p1">
            <span>X</span>
        </p>
        <p class="p2">确定退出当前用户？</p>
        <P class="p3">
            <a class="ok yes" href="#">确定</a><a class="ok no" href="#">取消</a>
        </p>
    </div>
</div>



</body>
</html>