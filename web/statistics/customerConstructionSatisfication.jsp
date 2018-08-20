<%--
  Created by IntelliJ IDEA.
  User: superzhaolu
  Date: 2018/8/18
  Time: 8:36
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
            <img src="../base/img/coin02.png" /><span><a href="#">客户构成分析</a></span>&nbsp;
        </div>
    </div>

    <div class="page">
        <form action="/statisticShow.do?method=findType" method="post">
            <div style="left: 490px;position: relative">
                <button class="button">帮助</button>
                <button  type="submit" class="button">查询</button>
            </div>
            <div class="cfD">
                报表方式：<select name="findType">
                <option value="kind">等级</option>
                <option value="credit">信誉度</option>
                <option value="satisfication" selected>满意度</option>
            </select>
            </div>
        </form>

        <div class="conShow">
            <table border="1" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="66px" class="tdColor tdC">编号</td>
                    <td width="350px" class="tdColor">满意度</td>
                    <td width="135px" class="tdColor">客户数量</td>
                </tr>
                <%int i =0;%>
                <c:forEach items="${findType}" var="m">
                    <tr>
                        <td><%=++i%></td>

                        <td><c:if test="${m.key==5}">⭐⭐⭐⭐⭐</c:if>
                            <c:if test="${m.key==4}">⭐⭐⭐⭐</c:if>
                            <c:if test="${m.key==3}">⭐⭐⭐</c:if>
                            <c:if test="${m.key==2}">⭐⭐</c:if>
                            <c:if test="${m.key==1}">⭐</c:if></td>
                        <td>${m.value}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
</body>
</html>

