
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>行家-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
    <!-- <script type="text/javascript" src="js/page.js" ></script> -->
</head>

<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="connoisseur.jsp">客户管理</a>&nbsp;-</span>&nbsp;客户信息管理
        </div>
    </div>

    <div class="page">
        <!-- banner页面样式 -->
        <div class="connoisseur">
            <div class="conform">
                <form>
                    <div class="cfD">
                            <button class="button"><a href="linkman.jsp">联系人</a></button>
                            <button class="button"><a href="communication.jsp">交易记录</button></a>
                            <button class="button"><a href="history.jsp">历史订单</button></a>
                        <a class="addA addA1" href="connoisseuradd.jsp">添加客户+</a>
                    </div>
                </form>
            </div>
            <!-- banner 表格 显示 -->
            <div class="conShow">
                <table border="1" cellspacing="0" cellpadding="0">
                    <tr>
                            <td width="50px" class="tdColor tdC">客户编号</td>
                            <td width="100px" class="tdColor">名称</td>
                            <td width="50px" class="tdColor">地区</td>
                            <td width="50px" class="tdColor">客户经理</td>
                            <td width="66px" class="tdColor">客户等级</td>
                            <td width="66px" class="tdColor">客户满意度</td>
                            <td width="66px" class="tdColor">客户信用度</td>
                            <td width="66px" class="tdColor">地址</td>
                            <td width="66px" class="tdColor">邮政编码</td>
                            <td width="66px" class="tdColor">电话</td>
                            <td width="66px" class="tdColor">网址</td>
                            <td width="66px" class="tdColor">操作</td>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>居家一条龙有限公司</td>
                        <td>陈明明</td>
                        <td>南京市</td>
                        <td><table>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                        </table>
                        </td>
                        <td><table>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                        </table>
                        </td>
                        <td><table>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                        </table>
                        </td>
                        <td>吧啦吧哭吧哭吧房间看撒比防不胜防开始了本菲卡说的</td>
                        <td>030032</td>
                        <td>www.cctv</td>
                        <td>13312345678</td>
                        <td><a href="connoisseurupdate.jsp"><img class="operation"
                               src="../base/img/update.png"></a> <img class="operation delban"
                               src="../base/img/delete.png"></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>一条龙服务有限公司</td>
                        <td>陈明明</td>
                        <td>南京市</td>
                        <td><table>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                        </table>
                        </td>
                        <td><table>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                        </table>
                        </td>
                        <td><table>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                            <tr><img src="../base/img/bullet_star.png"></tr>
                        </table>
                        </td>
                        <td>吧啦吧哭吧哭吧房间看撒比防不胜防开始了本菲卡说的</td>
                        <td>030032</td>
                        <td>www.cctv</td>
                        <td>13312345678</td>
                        <td><a href="connoisseurupdate.jsp"><img class="operation"
                               src="../base/img/update.png"></a> <img class="operation delban"
                               src="../base/img/delete.png"></td>
                    </tr>
                </table >
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
            <a><img src="../base/img/shanchu.png" /></a>
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
