<%@ page import="entity.Service" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  entity: dell
  Date: 2018/8/14
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>行家-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css"/>
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="js/page.js" ></script> -->

</head>

<script type="text/javascript">
    function myclick(b) {
        id = b;
        var a = document.getElementsByName("aDelete");
        var c = "/serve.do?method=delete&id=" + id;
        $('#aDelete_id').attr('href', c);
    }

</script>

<body>

<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png"/><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">服务分配</a>&nbsp;-</span>&nbsp;客户服务管理
        </div>
    </div>

    <div class="page">
        <!-- banner页面样式 -->
        <div class="connoisseur">
            <div class="conform">
                <div class="cfD" style="margin-top: 30px;margin-left: 50px">
                    <div class="cfD">
                        <%--<a href="communicationadd.jsp"><button class="button" style="position: absolute; right: 200px">新建</button></a>--%>
                        <button class="button" style="position: absolute;right: 130px;top: 10px;color: white"><a
                                href="/serve.do?method=query">查询</a></button>
                        <button class="button" style="position: absolute;right: 275px;top: 10px;color: white" type="submit">帮助
                        </button>
                        <br>
                    </div>
                    <form action="/serve.do?method=query" method="post" name="fom" id="fom">
                    <table width="90%">
                        <tr>
                            <td width="24"><img src="../base/img/ico07.gif" width="20" height="18"/></td>
                            <td width="519"><label>请输入关键字:
                                <input name="keyword" type="text"/>
                            </label>
                                </input>
                                <input name="Submit" type="submit" class="right-button02" value="查 询"/></td>
                            <td width="679" align="left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                        </tr>

                    </table>
                    </form>
                </div>
                <!-- banner 表格 显示 -->
                <div class="conShow">
                    <%--<form action="/serve.do?method=fenpei" method="post">--%>
                    <table border="1" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="66px" class="tdColor tdC">编号</td>
                            <td width="170px" class="tdColor">客户</td>
                            <td width="135px" class="tdColor">概要</td>
                            <td width="145px" class="tdColor">服务类型</td>
                            <td width="140px" class="tdColor">创建人</td>
                            <td width="140px" class="tdColor">创建日期</td>
                            <td width="145px" class="tdColor">分配给</td>
                            <td width="130px" class="tdColor">操作</td>
                        </tr>
                        <c:forEach items="${list}" var="ser">
                            <form action="/serve.do?method=fenpei&id=${ser.s_id} " method="post">
                            <tr>
                                <td><a href="#">${ser.s_id}</a></td>
                                <td><a href="#">${ser.customer.c_name}</a></td>
                                <td><a href="#">${ser.s_detail}</a></td>
                                <td><a href="#">${ser.s_type}</a></td>
                                <td><a href="#">${ser.role.r_name}</a></td>
                                <td><a href="#">${ser.s_time}</a></td>
                                <td><select id="dispose" name="dispose">
                                    <option value="小明">小明</option>
                                    <option value="旺财">旺财</option>
                                    <option value="球球">球球</option>
                                    <option value="孙小美">孙小美</option>
                                    <option value="周婕纶">周婕纶</option>
                                </select>
                                    <button class="button" style="color: white;background-color: #47a4e1" type="submit">
                                        分配
                                    </button>
                                </td>
                                <%--<td><a href="/serve.do?method=delete&id=${ser.s_id}">删除</a>--%>
                                <td><a href="javascript:void(0)" onclick="myclick(${ser.s_id})"><img class="operation delban" src="../base/img/delete.png"></a></td>

                            <%--<img--%>
                                        <%--class="operation delban"--%>
                                        <%--src="../base/img/delete.png">--%>
                                </td>
                            </tr>
                            </form>
                        </c:forEach>
                        <%
                            List<Service> list = (List<Service>) request.getAttribute("list");
                            if (list.isEmpty()) {
                        %>
                        <tr>
                            <td colspan="100" style="background-color: snow">没有查询到客户信息！</td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                   <%-- </form>--%>
                    <div class="paging">此处是分页</div>
                </div>
                <!-- banner 表格 显示 end-->
            </div>
            <!-- banner页面样式end -->
        </div>

    </div>


    <!-- 删除弹出框 -->
    <div class="banDel">
        <div class="delete">
            <div class="close">
                <a ><img src="../base/img/shanchu.png"/></a>
            </div>
            <p class="delP1">你确定要删除此条记录吗？</p>
            <p class="delP2">
                <a name="aDelete" id="aDelete_id" href="/customer.do?method=delete&cId" class="ok yes" >确定</a><a class="ok no">取消</a>
            </p>
        </div>
    </div>
</div>
</body>

 <script type="text/javascript">
     // 广告弹出框
     $(".delban").click(function () {
         $(".banDel").show();
     });
     $(".close").click(function () {
         $(".banDel").hide();
     });
     $(".no").click(function () {
         $(".banDel").hide();
     });
  // 广告弹出框 end
</script>
</html>
