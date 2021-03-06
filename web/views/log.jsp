<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/15
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% pageContext.setAttribute("path",request.getContextPath()); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/public.css" />
    <link rel="stylesheet" type="text/css" href="../base/css/page.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
    <script type="text/javascript" src="../base/js/public.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>

<!-- 登录页面头部 -->
<div class="logHead">
    <img src="../base/img/logLOGO.png" />
</div>
<!-- 登录页面头部结束 -->

<!-- 登录body -->
<div class="logDiv">
    <img class="logBanner" src="../base/img/logBanner.png" />
    <div class="logGet">
        <!-- 头部提示信息 -->
        <div class="logD logDtip">
            <p class="p1">登录</p>
            <p class="p2">有点人员登录</p>
        </div>
        <!-- 输入框 -->
        <form action="${path}/login.do" method="post">
            <div class="lgD">
                <img class="img1" src="../base/img/logName.png" /><input type="text" name="login_name"
                                                                 placeholder="输入用户名" />
            </div>
            <div class="lgD">
                <img class="img1" src="../base/img/logPwd.png" /><input type="password" name="login_password"
                                                                placeholder="输入用户密码" />
            </div>
           <div class="lgD">
               <select name="login_position">
                   <option value="高管">高管</option>
                   <option value="客户经理">客户经理</option>
               </select>
           </div>
            <div class="logC">
                <button type="submit">登 录</button>
            </div>
        </form>
    </div>
</div>
<!-- 登录body  end -->

<!-- 登录页面底部 -->
<div class="logFoot">
    <p class="p1">版权所有：南京设易网络科技有限公司</p>
    <p class="p2">南京设易网络科技有限公司 登记序号：苏ICP备11003578号-2</p>
</div>
<!-- 登录页面底部end -->
</body>
</html>