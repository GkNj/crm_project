
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>行家-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<script type="text/javascript">
    function myclick(b){
        cid=b;
        var a = document.getElementsByName("aDelete");
        var c="/customer.do?method=delete&cId="+cid;
        $('#aDelete_id').attr('href',c);
}

    function checkForm() {
        var radios = document.getElementsByName("queryid");
        var value;
        for (var i = 0; i < radios.length; i++) {
            if (radios[i].checked) {
                value = radios[i].value;
                location.href = "/linkman.do?method=query" + "&c_id=" + value;
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
                location.href = "/trade.do?method=query" + "&c_id=" + value;
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
                location.href = "/order.do?method=query" + "&c_id=" + value;
                break;
            }
        }
    }

        function go()
        {
            window.history.go(-1);
        }
</script>
<body>

<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="../views/main.jsp">首页</a>&nbsp;-&nbsp;客户信息管理</span>
        </div>
    </div>

    <div class="page">
        <!-- banner页面样式 -->
        <div class="connoisseur">
            <div class="conform">
                <form>
                    <div class="cfD">
                        <input name="Submit" type="button" class="button" value="联系人" onclick="checkForm();"/>
                        <input name="Submit" type="button" class="button" value="交往记录" onclick="checkForm1();"/>
                        <input name="Submit" type="button" class="button" value="历史订单" onclick="checkForm2();"/>
                        <a class="addA addA1" href="/customer.do?method=queryManager&id=">添加客户+</a>

                    </div>
                </form>
            </div>
            <!-- banner 表格 显示 -->
            <div class="conShow">
                <table border="1" cellspacing="0" cellpadding="0">
                    <tr>
                            <td width="50px" class="tdColor"></td>
                            <td width="80px" class="tdColor">客户编号</td>
                            <td width="100px" class="tdColor">名称</td>
                            <td width="50px" class="tdColor">地区</td>
                            <td width="80px" class="tdColor">客户经理</td>
                            <td width="66px" class="tdColor">客户等级</td>
                            <td width="66px" class="tdColor">客户满意度</td>
                            <td width="66px" class="tdColor">客户信用度</td>
                            <td width="66px" class="tdColor">地址</td>
                            <td width="66px" class="tdColor">邮政编码</td>
                            <td width="66px" class="tdColor">电话</td>
                            <td width="66px" class="tdColor">网址</td>
                            <td width="66px" class="tdColor">状态</td>
                            <td width="66px" class="tdColor">操作</td>
                    </tr>
                    <tr>
                        <c:forEach items="${list}" var="cus">
                    <tr style="height: 50px">

                    <td><input type="radio" id="queid" name="queryid" value="${cus.c_id}"/></td>

                        <td>${cus.c_id}</td>
                        <td>${cus.c_name}</td>
                        <td>${cus.c_area}</td>
                        <td>${cus.c_manager.r_name}</td>
                        <td>${cus.c_class}</td>
                        <td>
                            <c:if test="${cus.c_satifaction==1}">⭐</c:if>
                            <c:if test="${cus.c_satifaction==2}">⭐⭐</c:if>
                            <c:if test="${cus.c_satifaction==3}">⭐⭐⭐</c:if>
                            <c:if test="${cus.c_satifaction==4}">⭐⭐⭐⭐</c:if>
                            <c:if test="${cus.c_satifaction==5}">⭐⭐⭐⭐⭐</c:if>
                        </td>
                        <td>
                            <c:if test="${cus.c_credit==1}">⭐</c:if>
                            <c:if test="${cus.c_credit==2}">⭐⭐</c:if>
                            <c:if test="${cus.c_credit==3}">⭐⭐⭐</c:if>
                            <c:if test="${cus.c_credit==4}">⭐⭐⭐⭐</c:if>
                            <c:if test="${cus.c_credit==5}">⭐⭐⭐⭐⭐</c:if>
                        </td>
                        <td>${cus.c_address}</td>
                        <td>${cus.c_portcode}</td>
                        <td>${cus.c_tel}</td>
                        <td>${cus.c_website}</td>
                        <td>${cus.c_state}</td>
                        <td><a href="/customer.do?method=queryById&cId=${cus.c_id}"><img class="operation" src="../base/img/update.png"></a>
                            <a href="javascript:void(0)" onclick="myclick(${cus.c_id})"><img class="operation delban" src="../base/img/delete.png"></a></td>
                    </tr>
                    </c:forEach>
                    </tr>
                </table >
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
            <a><img src="../base/img/shanchu.png" /></a>
        </div>
        <p class="delP1">你确定要删除此条记录吗？</p>
        <p class="delP2">
            <a name="aDelete" id="aDelete_id" href="/customer.do?method=delete&cId" class="ok yes" >确定</a><a class="ok no">取消</a>
        </p>
    </div>
</div>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>
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
