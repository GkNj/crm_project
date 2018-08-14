<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/14
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>话题添加-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css"/>
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png"/><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">服务创建</a>&nbsp;-</span>&nbsp;服务添加
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">
            <div class="baTopNo">
                <span>服务添加</span>
            </div>
            <div class="cfD">
                <%--<a href="communicationadd.jsp"><button class="button" style="position: absolute; right: 200px">新建</button></a>--%>
                <button class="button" style="position: absolute;right: 130px">帮助</button>
                <button class="button" style="position: absolute;right: 275px">保存</button><br>
            </div>
            <div class="cfD" style="margin-top: 30px;margin-left: 50px">
                <table width="90%">
                    <tr>
                        <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">编号</td>
                        <td width="30%" class="tdColor" style="color: black;text-align: left"><input type="text"></td>
                        <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">服务类型</td>
                        <td width="40%" class="tdColor" style="color: black"><select name="" id="">
                            <option value="">咨询</option>
                            <option value="">建议</option>
                            <option value="">投诉</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">概要</td>
                        <td width="30%" colspan="3" class="tdColor" style="color: black ;text-align: left"><input type="text"></td>
                    </tr>
                    <tr>
                        <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户</td>
                        <td width="30%" class="tdColor" style="color: black;text-align: left"><input type="text"></td>
                        <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">状态</td>
                        <td width="40%" class="tdColor" style="color: black">新创建</td>
                    </tr>
                    <tr>
                        <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">服务请求</td>
                        <td colspan="3" width="30%" class="tdColor" style="color: black"><textarea style="width: 350px;height: 80px"></textarea></td>
                    </tr>
                    <tr>
                        <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户</td>
                        <td width="30%" class="tdColor" style="color: black;text-align: left"><input type="text" value="刘颖"></td>
                        <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">创建时间</td>
                        <td width="40%" class="tdColor" style="color: black;text-align: left"><input type="text" value="2007-11-26 10:47:5"></td>
                    </tr>
                </table>
            </div>
        </div>

        <!-- 上传广告页面样式end -->
    </div>
</div>
</body>
</html>
