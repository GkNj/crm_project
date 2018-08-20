<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新建联系人-有点</title>
	<link rel="stylesheet" type="text/css" href="../base/css/css.css" />
	<script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<script type="text/javascript">
    function go()
    {
        window.history.go(-1);
    }
</script>
<body>
<div id="pageAll">
	<div class="pageTop">
		<div class="page">
			<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a></span>&nbsp;-&nbsp;新建联系人
		</div>
	</div>
	<div class="page ">
		<!-- 上传广告页面样式 -->
		<div class="banneradd bor">
			<form action="${path}/linkman.do?method=addSave&cId=<%=request.getParameter("cId")%>" method="post">

			<div class="baTop">
				<span>新建联系人</span>
			</div>
			<div class="baBody">
				<div class="bbD">
					姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" class="input1" name="l_name" />
				</div>
				<div class="bbD">
					职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：<input type="text" class="input1" name="l_position"/>
				</div>
				<div class="bbD">
					办公电话：<input type="text" class="input1" name="l_tel"/>
				</div>
				<div class="bbD">
					手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：<input type="text" class="input1" name="l_phone"/>
				</div>
				<div class="bbD">
					备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" class="input1" name="l_remark"/>
				</div>
				<div class="bbD">
					<p class="bbDP">
						<input type="submit" name="Submit" value="保存" class="btn_ok btn_yes"/>　
						<a class="btn_ok btn_no" href="/linkman.do?method=query&c_id=<%=request.getParameter("cId")%>">取消</a>
					</p>
				</div>
			</div>
			</form>
		</div>

		<!-- 上传广告页面样式end -->
	</div>
</div>
</body>
</html>