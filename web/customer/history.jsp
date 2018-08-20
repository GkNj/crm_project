<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>历史订单-有点</title>
<link rel="stylesheet" type="text/css" href="../base/css/css.css" />
<script type="text/javascript" src="../base/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>
<script type="text/javascript">
    function myclick(b){
        lid=b;
        var a = document.getElementsByName("aDelete");
        var c="/linkman.do?method=delete&id="+lid+"&c_id="+$('#hahaha').attr('value');
        $('#aDelete_id').attr('href',c);

    }
    function checkForm() {
        location.href = "/customer.do?method=query";
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
				<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;客户信息&nbsp;-历史订单
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
						<div class="cfD">
							<form action="/customer/orderadd.jsp?cId=${cId}" method="post">
							<input name="Submit" type="button" class="button" style="float:right" value="返回" onclick="checkForm();"/><br>
							</form>
						</div>
						<div class="cfD" style="margin-top: 30px">
								<table width="100%">
									<c:forEach items="${list1}" var="cus">
										<tr>
											<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户编号</td>
											<td width="30%" class="tdColor" style="color: black">${cus.c_id}</td>
											<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">客户名称</td>
											<td width="40%" class="tdColor" style="color: black">${cus.c_name}</td>
										</tr>
									</c:forEach>
								</table>
						</div>
				</div>
				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="110px" class="tdColor tdC">订单编号</td>
							<td width="310px" class="tdColor">日期</td>
							<td width="320px" class="tdColor">送货地址</td>
							<td width="275px" class="tdColor">状态</td>
							<td width="290px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${list}" var="order">
							<tr style="height: 50px">
								<td>${order.o_id}</td>
								<td>${order.o_time}</td>
								<td>${order.o_position}</td>
								<td>${order.o_state}</td>
								<td><a href="/order.do?method=queryProduct&o_id=${order.o_id}"><img class="operation"
																									src="../base/img/mingxi.png"></a></td>
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