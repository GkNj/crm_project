<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/14
  Time: 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("path", request.getContextPath()); %>
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
            <form action="${path}/serve.do?method=create" method="post">
                <div class="cfD">
                    <%--<a href="communicationadd.jsp"><button class="button" style="position: absolute; right: 200px">新建</button></a>--%>
                    <button class="button" style="position: absolute;right: 130px">帮助</button>
                    <button class="button" style="position: absolute;right: 275px" type="submit">保存</button>
                    <br>
                </div>
                <div class="cfD" style="margin-top: 30px;margin-left: 50px">
                    <table width="90%">
                        <tr>
                            <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">编号</td>
                            <td width="30%" class="tdColor" style="color: black;text-align: left"><input type="text" name="s_id">
                            </td>
                            <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">服务类型</td>
                            <td width="40%" class="tdColor" style="color: black"><select name="s_type" id="">
                                <option value="咨询">咨询</option>
                                <option value="建议">建议</option>
                                <option value="投诉">投诉</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">概要</td>
                            <td width="30%" colspan="3" class="tdColor" style="color: black ;text-align: left"><input
                                    type="text" name="s_detail"></td>
                        </tr>
                        <tr>
                            <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">客户</td>
                            <td width="30%" class="tdColor" style="color: black;text-align: left"><input type="text" name="customer">
                            </td>
                            <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">状态</td>
                            <td width="40%" class="tdColor" style="color: black"><input value="新创建" name="s_state"></td>
                        </tr>
                        <tr>
                            <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">服务请求
                            </td>
                            <td colspan="3" width="30%" class="tdColor" style="color: black"><textarea
                                    style="width: 350px;height: 80px" name="s_request"></textarea></td>
                        </tr>
                        <tr>
                            <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">创建人
                            </td>
                            <td width="30%" class="tdColor" style="color: black;text-align: left"><input type="text" value="张三" name="role">
                            </td>
                            <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">创建时间</td>
                            <jsp:useBean id="time" class="java.util.Date"/>
                            <td width="40%" class="tdColor" style="color: black;text-align: left"> <input name="s_time" id="s_time" value="
    <fmt:formatDate value="<%=time%>" pattern="yyyy-MM-dd  HH :mm:ss"/>" class="text" style="width:250px" type="text" size="40"/>
                                <span class="red" style="color: red"> *</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

        <!-- 上传广告页面样式end -->
    </div>
</div>
</body>
</html>
