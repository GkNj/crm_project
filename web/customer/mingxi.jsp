<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>订单明细-有点</title>
	<link rel="stylesheet" type="text/css" href="../base/css/css.css" />
	<script type="text/javascript" src="../base/js/jquery.min.js"></script>
	<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<script language="JavaScript">
        function go()
        {
            window.history.go(-1);
        }
</SCRIPT>
<body>
<div id="pageAll">
	<div class="pageTop">
		<div class="page">
			<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;客户信息&nbsp;-历史订单&nbsp;-订单明细
		</div>
	</div>

	<div class="page">
		<!-- banner页面样式 -->
		<div class="connoisseur">
			<div class="conform">
				<div class="cfD">
					<input type="button" style="float: right; width: 135px;height: 30px;border: none;font-size: 16px;color: #fff;background-color: #47a4e1;"
						   							name="Submit" onclick="javascript:history.back(-1);" value="返回"><br>
				</div>
				<div class="cfD" style="margin-top: 30px">
					<table width="100%">
						<c:forEach items="${list2}" var="order">
							<tr>
								<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">订单编号</td>
								<td width="30%" class="tdColor" style="color: black">${order.o_id}</td>
								<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">日期</td>
								<td width="40%" class="tdColor" style="color: black">${order.o_time}</td>
							</tr>
							<tr>
								<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">送货地址</td>
								<td width="30%" class="tdColor" style="color: black">${order.o_position}</td>
								<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">总金额（元）</td>
								<td width="40%" class="tdColor" style="color: black">${requestScope.sum}</td>
							</tr>
							<tr>
								<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">状态</td>
								<td width="30%" class="tdColor" style="color: black">${order.o_state}</td>
								<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black"></td>
								<td width="40%" class="tdColor" style="color: black"></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<!-- banner 表格 显示 -->
			<div class="conShow">
				<table border="1" cellspacing="0" cellpadding="0">
					<tr width="100%">
						<td width="100px" class="tdColor tdC">编号</td>
						<td width="400px" class="tdColor tdC">商品</td>
						<td width="190px" class="tdColor">数量</td>
						<td width="190px" class="tdColor">单位</td>
						<td width="300px" class="tdColor">单价（元）</td>
						<td width="350px" class="tdColor">金额（元）</td>
					</tr>
					<c:forEach items="${list}" var="pro">
						<tr style="height: 50px;">
							<td>${pro.p_id}</td>
							<td>${pro.p_name}</td>
							<td>${pro.p_num}</td>
							<td>${pro.p_unit}</td>
							<td>${pro.p_price}</td>
							<td>${pro.p_price*pro.p_num}</td>
						</tr>
					</c:forEach>
				</table>
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
			<a><img src="img/shanchu.png" /></a>
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