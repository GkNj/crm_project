<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单明细-有点</title>
<link rel="stylesheet" type="text/css" href="../base/css/css.css" />
<script type="text/javascript" src="../base/js/jquery.min.js"></script>
<!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">客户流失管理</a>&nbsp;-</span>&nbsp;确认流失
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
						<div class="cfD">
								<%--<a href="communicationadd.jsp"><button class="button" style="position: absolute; right: 200px">新建</button></a>--%>
								<button class="button" style="position: absolute;right: 130px">返回</button>
								<button class="button" style="position: absolute;right: 275px">保存</button><br>
						</div>
						<div class="cfD" style="margin-top: 30px;margin-left: 50px">
								<table width="90%">
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">编号</td>
										<td width="30%" class="tdColor" style="color: black">1</td>
										<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">客户</td>
										<td width="40%" class="tdColor" style="color: black">阳光实业</td>
									</tr>
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户经理</td>
										<td width="30%" class="tdColor" style="color: black">球球</td>
										<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">上次下单时间</td>
										<td width="40%" class="tdColor" style="color: black">2005-12-13</td>
									</tr>
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">暂缓措施</td>
										<td width="30%" colspan="3" class="tdColor" style="color: black">已回款水水水水水水水水水水水水水水水水</td>
									</tr>
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">流失原因</td>
										<td colspan="3" width="30%" class="tdColor" style="color: black"><textarea style="width: 350px;height: 80px"></textarea></td>
									</tr>
								</table>
						</div>
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