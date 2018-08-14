<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>交往记录管理-有点</title>
<link rel="stylesheet" type="text/css" href="../base/css/css.css" />
<script type="text/javascript" src="../base/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">客户信息管理</a>&nbsp;-</span>&nbsp;客户信息&nbsp;-交往记录
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
						<div class="cfD">
								<a href="communicationadd.jsp"><button class="button" style="position: absolute; right: 200px">新建</button></a>
								<button class="button" style="float: right">返回</button><br>
						</div>
						<div class="cfD" style="margin-top: 30px">
								<table width="100%">
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户编号</td>
										<td width="30%" class="tdColor" style="color: black">001</td>
										<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">客户名称</td>
										<td width="40%" class="tdColor" style="color: black">聪海信息科技有限公司</td>
									</tr>
								</table>
						</div>
				</div>
				<!-- banner 表格 显示 -->
				<div class="conShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr width="100%">
							<td width="400px" class="tdColor tdC">时间</td>
							<td width="190px" class="tdColor">地点</td>
							<td width="300px" class="tdColor">概要</td>
							<td width="350px" class="tdColor">备注</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<tr style="height: 50px;">
							<td>2007-03-12 12:30:00</td>
							<td>
								友谊宾馆
							</td>
							<td>签订意向协议</td>
							<td>主办单位：计算机报社</td>
							<td><a href="communicationadd.jsp"><img class="operation"
									src="../base/img/update.png"></a> <img class="operation delban"
								src="../base/img/delete.png"></td>
						</tr>
					</table>
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