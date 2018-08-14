<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/14
  Time: 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>行家-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css"/>
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png"/><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">服务分配</a>&nbsp;-</span>&nbsp;客户服务管理
        </div>
    </div>

    <div class="page">
        <!-- banner页面样式 -->
        <div class="connoisseur">
            <div class="conform">
                <form>
                    <div class="cfD" style="left: 800px ;top:-10px ;position: absolute">
                        <button class="button">帮助</button>
                        <button class="button">查询</button>
                    </div>
                    <div class="bbD">
                        客户:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                    </div>
                    <div class="bbD">
                        概要:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                    </div>
                    <div class="bbD">
                        服务类型:<select class="input3">
                        <option value="">全部</option>
                        <option value="">咨询</option>
                        <option value="">建议</option>
                        <option value="">投诉</option>
                    </select>
                    </div>
                    <div class="bbD">
                        创建日期：<input type="text" class="input3"/>
                    </div>
                    <div class="bbD">
                        状态:&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<select class="input3">
                        <option value="">新创建</option>
                        <option value="">已分配</option>
                    </select>
                    </div>
                </form>
                <!-- banner 表格 显示 -->
                <div class="conShow">
                    <table border="1" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="66px" class="tdColor tdC">编号</td>
                            <td width="170px" class="tdColor">客户</td>
                            <td width="135px" class="tdColor">概要</td>
                            <td width="145px" class="tdColor">服务类型</td>
                            <td width="140px" class="tdColor">创建人</td>
                            <td width="140px" class="tdColor">创建日期</td>
                            <td width="145px" class="tdColor">分配给</td>
                            <td width="130px" class="tdColor">操作</td>
                        </tr>
                        <tr>
                            <td>1</td>
                            <td>张三</td>
                            <td>山下就只</td>
                            <td>13312345678</td>
                            <td>南京市</td>
                            <td>南京设疑网络科技公司哈哈哈</td>
                            <td>总监</td>
                            <td><a href="connoisseuradd.html"><img class="operation"
                                                                   src="../base/img/update.png"></a> <img
                                    class="operation delban"
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
                <a><img src="../base/img/shanchu.png"/></a>
            </div>
            <p class="delP1">你确定要删除此条记录吗？</p>
            <p class="delP2">
                <a href="#" class="ok yes">确定</a><a class="ok no">取消</a>
            </p>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    // 广告弹出框
    $(".delban").click(function () {
        $(".banDel").show();
    });
    $(".close").click(function () {
        $(".banDel").hide();
    });
    $(".no").click(function () {
        $(".banDel").hide();
    });
    // 广告弹出框 end
</script>
</html>
