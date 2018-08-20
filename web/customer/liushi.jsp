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
<script type="text/javascript">

    function checkForm1(){
        location.href="/liushi.do?method=query";

    }
    function checkForm2(){
        document.getElementById("fom").action="${path}/liushi.do?method=save&l_id="+$('#hehehe').attr('value');
        document.getElementById("fom").submit();

    }
</script>
<body>
<div id="pageAll">
	<div class="pageTop">
		<div class="page">
			<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户流失管理</a>&nbsp;-</span>&nbsp;暂缓流失
		</div>
	</div>

	<div class="page">
		<!-- banner页面样式 -->
		<div class="connoisseur">
			<div class="conform">
				<form method="post" action="" id="fom">
					<div class="cfD">
						<input name="Submit" type="button" class="button" style="position: absolute;right: 120px" value="返回" onclick="checkForm1();"/>
						<input name="Submit" type="button" class="button" style="position: absolute;right: 300px" value="保存" onclick="checkForm2();"/>
						<br>
						<div class="cfD" style="margin-top: 30px;margin-left: 50px">
							<table width="90%">
								<c:forEach items="${list}" var="lost">
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">编号</td>
										<td width="30%" class="tdColor" style="color: black"><input type="text" value="${lost.l_id}" style="border: none;background-color: #f2f2f2;text-align: center" readonly  unselectable="on" id="hehehe"/></td>
										<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">客户</td>
										<td width="40%" class="tdColor" style="color: black">${lost.customer.c_name}</td>
									</tr>
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户经理</td>
										<td width="30%" class="tdColor" style="color: black">${lost.role.r_name}</td>
										<td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">上次下单时间</td>
										<td width="40%" class="tdColor" style="color: black">${lost.l_time}</td>
									</tr>
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">暂缓措施</td>
										<td width="30%" colspan="3" class="tdColor" style="color: black"><input type="textarea" value="${lost.l_measure}" style="width:100%; border: none;background-color: #f2f2f2;text-align: center" readonly  unselectable="on" name="hahaha"/></td>
									</tr>
									<tr>
										<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">追加暂缓措施</td>
										<td colspan="3" width="30%" class="tdColor" style="color: black"><textarea name="runadd" style="width: 350px;height: 80px"></textarea></td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</div>
				</form>
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