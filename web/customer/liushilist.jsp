
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>客户信息管理-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<script language="JavaScript">
    function checkForm() {
        var radios = document.getElementsByName("queryid");
        var value;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                value = radios[i].value;
                location.href = "linkman.do?method=query" + "&c_id=" + value;
                break;
            }
        }
    }
    function checkForm1() {
        var radios = document.getElementsByName("queryid");
        var value;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                value = radios[i].value;
                location.href = "trade.do?method=query" + "&c_id=" + value;
                break;
            }
        }
    }
    function checkForm2() {
        var radios = document.getElementsByName("queryid");
        var value;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                value = radios[i].value;
                location.href = "order.do?method=query" + "&c_id=" + value;
                break;
            }
        }
    }

</script>

<body>
<form action="customer.do?method=query" method="post">
    <div id="pageAll">
        <div class="pageTop">
            <div class="page">
                <img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a href="../views/main.jsp">客户管理</a>&nbsp;-</span>&nbsp;流失管理
            </div>
        </div>

        <div class="page">
            <!-- banner页面样式 -->
            <div class="connoisseur">
                <div class="conform">
                    <form>
                        <div class="cfD">
                            <%--<input name="Submit" type="button" class="button" value="详情" onclick="checkForm();"/>--%>
                            <%--<input name="Submit" type="button" class="button" value="交往记录" onclick="checkForm1();"/>--%>
                            <%--<input name="Submit" type="button" class="button" value="历史订单" onclick="checkForm2();"/>--%>
                            <%--<a class="addA addA1" href="connoisseuradd.jsp">添加客户+</a>--%>
                        </div>
                    </form>
                </div>
                <!-- banner 表格 显示 -->
                <div class="conShow">
                    <table border="1" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="80px" class="tdColor tdC">编号</td>
                            <td width="100px" class="tdColor">客户名称</td>
                            <td width="80px" class="tdColor">客户经理</td>
                            <td width="90px" class="tdColor">上次下单时间</td>
                            <td width="90px" class="tdColor">状态</td>
                            <td width="120px" class="tdColor" >操作</td>
                        </tr>
                        <c:forEach items="${lostlist}" var="lost">
                            <tr style="height: 50px">
                                <td><a>${lost.l_id}</a></td>
                                <td><a>${lost.customer.c_name}</a></td>
                                <td>${lost.role.r_name}</td>
                                <td>${lost.l_time}</td>
                                <td>${lost.l_state}</td>
                                <td><a href="/liushi.do?method=queryLost&l_id=${lost.l_id}"><img style="margin-top: 3px" class="operation" src="../base/img/update.png"></a>

                                    <div style="padding-top: 5px;float: right; margin-right: 3px;border-radius: 5px" >
                                        <a href="/liushi.do?method=confirm&l_id=${lost.l_id}" style=" border: 1px gainsboro solid;margin-bottom: 5px;border-radius: 38px;">确认流失</a>
                                    </div>
                                </td>

                            </tr>
                        </c:forEach>
                    </table >
                </div>
                <!-- banner 表格 显示 end-->
            </div>

            <!-- banner页面样式end -->
        </div>

    </div>
</form>


<!-- 删除弹出框 -->
<div class="banDel">
    <div class="delete">
        <div class="close">
            <a><img src="../base/img/shanchu.png" /></a>
        </div>
        <p class="delP1">你确定要删除此条记录吗？</p>
        <p class="delP2">
            <a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
        </p>
    </div>
</div>
<!-- 删除弹出框  end-->
</body>

<script type="text/javascript">
    // 广告弹出框
    $(".delban").click(function(){
        $(".banDel").show();
    });
    $(".close").click(function(){
        $(".banDel").hide();
    });
    $(".no").click(function(){
        $(".banDel").hide();
    });
    // 广告弹出框 end
</script>
</html>
