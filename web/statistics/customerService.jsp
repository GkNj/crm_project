<%--
  Created by IntelliJ IDEA.
  User: superzhaolu
  Date: 2018/8/17
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
    <title>客户分析</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<body>
<div id="pageAll">

    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="#">客户服务分析</a></span>&nbsp;
        </div>
    </div>

    <div class="page">
        <form action="/statisticShow.do?method=findByService" method="post">
            <div style="left: 490px;position: relative">
                <button class="button">帮助</button>
                <button  type="submit" class="button">查询</button>
            </div>
            <div class="cfD">
                年份：<select name="year">
                <option value="">请选择年份</option>
                <option value="2016">2016</option>
                <option value="2017">2017</option>
                <option value="2018">2018</option>
            </select>
            </div>
        </form>

        <div class="conShow">
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="66px" class="tdColor tdC">编号</td>
                    <td width="135px" class="tdColor">条目</td>
                    <td width="350px" class="tdColor">服务数量</td>
                </tr>
                <%int i =0;%>
                <c:forEach items="${findByService}" var="s">
                    <tr>
                        <td><%=++i%></td>
                        <td>${s.key}</td>
                        <td>${s.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>
