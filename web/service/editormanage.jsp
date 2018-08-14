<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/14
  Time: 10:32
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
            <div class="cfD" style="left: 500px ;top:-10px ;position: absolute">
                <button class="button">帮助</button>
                <button class="button">返回</button>
                <button class="button">保存</button>
            </div>
            <div class="baTopNo">
                <span>服务添加</span>
            </div>
            <div class="baBody">
                <div class="bbD">
                    编号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    服务类型:&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    概要：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    客户：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    状态:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    服务请求：
                    <input type="text" class="input3"/>
                </div>

                <div class="bbD">
                    创建人：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    创建时间：<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    分配给:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                   分配时间：<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    服务处理：
                    <div class="btext">
                        <textarea class="text2"></textarea>
                    </div>
                </div>
                <div class="bbD">
                    处理人：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" class="input3"/>
                </div>
                <div class="bbD">
                    处理时间：<input type="text" class="input3"/>
                </div>
            </div>
        </div>

        <!-- 上传广告页面样式end -->
    </div>
</div>
</body>
</html>

