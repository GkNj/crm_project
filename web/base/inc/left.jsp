<%--
  Created by IntelliJ IDEA.
  entity: dell
  Date: 2018/8/13
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>首页左侧导航</title>
    <link rel="stylesheet" type="text/css" href="../css/public.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/public.js"></script>
    <head></head>

<body id="bg">
<!-- 左边节点 -->
<div class="container">

    <div class="leftsidebar_box">
        <a href="../main.html" target="main">
            <div class="line">
                <img src="../img/coin01.png"/>&nbsp;&nbsp;首页
            </div>
        </a>

        <dl class="system_log">
            <dt>
                <img class="icon1" src="../img/coin07.png"/><img class="icon2"
                 src="../img/coin08.png"/> 客户管理<img class="icon3" src="../img/coin19.png"/><img
                    class="icon4"
                    src="../img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                     src="../img/coin222.png"/><a href="../../customer/connoisseur.jsp" target="main" class="cks">客户信息管理</a><img
                    class="icon5" src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                src="../img/coin222.png"/><a href="../../customer/liushi.jsp" target="main"
                class="cks">客户流失管理</a><img class="icon5" src="../img/coin21.png"/>
            </dd>
        </dl>

        <dl class="system_log">
            <dt>
                <img class="icon1" src="../img/coin14.png"/><img class="icon2"
                                                                 src="../img/coin13.png"/> 服务管理<img class="icon3"
                                                                                                    src="../img/coin19.png"/><img
                    class="icon4"
                    src="../img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../../service/create.jsp"
                                                                                                target="main"
                                                                                                class="cks">服务创建</a><img
                    class="icon5" src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="${path}/serve.do?method=query"
                                                                                                target="main"
                                                                                                class="cks">服务分配</a><img
                    class="icon5" src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../../service/manage.jsp"
                                                                                                target="main"
                                                                                                class="cks">服务处理</a><img
                    class="icon5" src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../../service/feedback.jsp"
                                                                                                target="main"
                                                                                                class="cks">服务反馈</a><img
                    class="icon5" src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../../service/sum.jsp"
                                                                                                target="main"
                                                                                                class="cks">服务归档</a><img
                    class="icon5" src="../img/coin21.png"/>
            </dd>
        </dl>

        <dl class="system_log">
            <dt>
                <img class="icon1" src="../img/coin17.png"/><img class="icon2"
                                                                 src="../img/coin18.png"/> 统计报表<img class="icon3"
                                                                                                    src="../img/coin19.png"/><img
                    class="icon4"
                    src="../img/coin20.png"/>
            </dt>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../../statistics/customerContribute.html"
                                                                                                target="main"
                                                                                                class="cks">客户贡献分析</a><img
                    class="icon5"
                    src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../balance.html"
                                                                                                target="main"
                                                                                                class="cks">客户构成分析</a><img
                    class="icon5"
                    src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../balance.html"
                                                                                                target="main"
                                                                                                class="cks">客户服务分析</a><img
                    class="icon5"
                    src="../img/coin21.png"/>
            </dd>
            <dd>
                <img class="coin11" src="../img/coin111.png"/><img class="coin22"
                                                                   src="../img/coin222.png"/><a href="../balance.html"
                                                                                                target="main"
                                                                                                class="cks">客户流失分析</a><img
                    class="icon5"
                    src="../img/coin21.png"/>
            </dd>
        </dl>

    </div>

</div>
</body>
</html>

