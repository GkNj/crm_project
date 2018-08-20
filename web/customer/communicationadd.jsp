<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新建交往记录-有点</title>
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
				<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;交往记录-新建交往记录
			</div>
		</div>
		<div class="page ">
			<!-- 上传广告页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>新建交往记录</span>
				</div>
				<div class="baBody">
					<form action="${path}/trade.do?method=addSave&cId=<%=request.getParameter("cId")%>" method="post">
						<div class="bbD">
							时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：<input type="text" class="input1" name="t_time"/>
						</div>
						<div class="bbD">
							地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;点：<input type="text" class="input1" name="t_address"/>
						</div>
						<div class="bbD">
							概&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;要：<input type="text" class="input1" name="t_outline"/>
						</div>
						<div class="bbD">
							备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input type="text" class="input1" name="t_remark"/>
						</div>
						<div class="bbD">
							<p class="bbDP">

								<input type="submit" name="Submit" value="保存" class="btn_ok btn_yes"/>　
								<a class="btn_ok btn_no" href="/trade.do?method=query&c_id=<%=request.getParameter("cId")%>">取消</a>

							</p>
						</div>
					</form>
				</div>
			</div>

			<!-- 上传广告页面样式end -->
		</div>
	</div>
</body>
</html>