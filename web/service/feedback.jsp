<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>服务反馈</title>
<link rel="stylesheet" type="text/css" href="../base/css/css.css" />
<script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="../base/img/coin02.png" /><span><a href="#">服务管理</a>&nbsp;-</span>&nbsp;服务反馈
				<div class="cfD" style="left: 800px ;top:-10px ;position: absolute">
					<button class="button">帮助</button>
						<button class="button">查询</button>
				</div>
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTopNo"><span>服务反馈</span></div>
				<div class="baBody">
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户：<input type="text" class="input3" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;概要：<input type="text" class="input3" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服务类型：<select class="input3"><option>咨询</option><option>建议</option><option>投诉</option></select>
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建日期：<input class="input3" type="text" />
					</div>
					<div class="bbD">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;状态：<select class="input3"><option>已处理</option><option>未处理</option></select>
					</div>
					<div class="conShow">
						<table border="1" cellspacing="0" cellpadding="0">
							<tr>
								<td width="66px" class="tdColor tdC">编号</td>
								<td width="305px" class="tdColor">客户</td>
								<td width="275px" class="tdColor">概要</td>
								<td width="315px" class="tdColor">服务类型</td>
								<td width="240px" class="tdColor">创建人</td>
								<td width="330px" class="tdColor">创建日期</td>
								<td width="130px" class="tdColor">操作</td>
							</tr>
							<tr height="85px">
								<td>455</td>
								<td>太阳药业</td>
								<td>询问收音机价格</td>
								<td>咨询</td>
								<td>小明</td>
								<td>2007年12月02日</td>
								<td><a href="banneradd.html"><img class="operation" src="../base/img/update.png"></a>
									<img class="operation delban" src="../base/img/delete.png"></td>
							</tr>
							<tr height="85px">
								<td>454</td>
								<td>云南天河烟草公司</td>
								<td>询问收音机价格</td>
								<td>建议</td>
								<td>小李</td>
								<td>2007年12月02日</td>
								<td><a href="banneradd.html"><img class="operation" src="../base/img/update.png"></a>
									<img class="operation delban" src="../base/img/delete.png"></td>
							</tr>
						</table>
						<div class="paging">此处是分页</div>
					</div>
					<div class="bbD">
						<p class="bbDP">
							<button class="btn_ok btn_yes" href="#">保存</button>
							<a class="btn_ok btn_no" href="#">取消</a>
						</p>
					</div>
				</div>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>