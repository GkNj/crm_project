<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>联系人管理-有点</title>
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
				<img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;客户信息&nbsp;-联系人
			</div>
		</div>

		<div class="page">
			<!-- banner页面样式 -->
			<div class="connoisseur">
				<div class="conform">
					<div class="cfD">
						<form action="/customer/linkmanadd.jsp?cId=${cId}" method="post">
						<button class="button" style="position: absolute; right: 200px">新建</button>
						<input name="Submit" type="button" class="button" style="float:right" value="返回" onclick="checkForm();"/>
						</form>
					<br/>
					</div>

					<div class="cfD" style="margin-top: 30px">

						<table width="100%">
							<c:forEach items="${list1}" var="cus">
								<tr>
									<td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户编号</td>
									<td width="30%" id="TdC_id" class="tdColor" style="color: black"><input type="text" value="${cus.c_id}" style="border: none;background-color: #f2f2f2;text-align: center" readonly  unselectable="on" id="hahaha"/></td>

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
							<td width="110px" class="tdColor tdC">编号</td>
							<td width="90px" class="tdColor">姓名</td>
							<td width="260px" class="tdColor">职位</td>
							<td width="275px" class="tdColor">办公电话</td>
							<td width="290px" class="tdColor">手机</td>
							<td width="290px" class="tdColor">备注</td>
							<td width="130px" class="tdColor">操作</td>
						</tr>
						<c:forEach items="${list}" var="linkman">
							<tr style="height: 50px">
								<td>${linkman.l_id}</td>
								<td>${linkman.l_name}</td>
								<td>${linkman.l_position}</td>
								<td>${linkman.l_tel}</td>
								<td>${linkman.l_phone}</td>
								<td>${linkman.l_remark}</td>
								<td>
									<%--<a href="/linkman.do?method=queryById&lId=${linkman.l_id}"><img class="operation" src="../base/img/update.png"></a>--%>
									<a href="javascript:void(0)" onclick="myclick(${linkman.l_id})"><img class="operation delban" src="../base/img/delete.png"></a></td>
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
				<a name="aDelete" id="aDelete_id" href="/linkman.do?method=delete&id" class="ok yes" >确定</a><a class="ok no">取消</a>

			</p>
		</div>
	</div>
</form>
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