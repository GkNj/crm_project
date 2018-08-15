
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>行家-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="connoisseur.jsp">客户信息管理</a>&nbsp;-</span>&nbsp;添加客户信息
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">
            <div class="baTopNo">
                <span>客户信息添加</span>
            </div>

        <div class="baBody">
            <form action="${path}/customer.do?method=add" method="post">
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" />
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地区: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select class="input3">
                    <option>北京市</option>
                    <option>南京市</option>
                    <option>成都市</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户经理: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select class="input3">
                    <option>陈明明</option>
                    <option>小红</option>
                    <option>小黑</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户等级: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select class="input3">
                    <option>⭐⭐⭐⭐⭐</option>
                    <option>⭐⭐⭐⭐</option>
                    <option>⭐⭐⭐</option>
                    <option>⭐⭐</option>
                    <option>⭐</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户满意度: &nbsp;
                <select class="input3">
                    <option>⭐⭐⭐⭐⭐</option>
                    <option>⭐⭐⭐⭐</option>
                    <option>⭐⭐⭐</option>
                    <option>⭐⭐</option>
                    <option>⭐</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户信用度: &nbsp;
                <select class="input3">
                    <option>⭐⭐⭐⭐⭐</option>
                    <option>⭐⭐⭐⭐</option>
                    <option>⭐⭐⭐</option>
                    <option>⭐⭐</option>
                    <option>⭐</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" />
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" />
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" />
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" />
            </div>
            <%--<div class="bbD">--%>
            <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户状态：--%>
            <%--<label><input type="radio" checked="checked" name="styleshoice1" />&nbsp;正常</label>--%>
            <%--<label><input type="radio" name="styleshoice1" />&nbsp;已流失</label>--%>
            <%--</div>--%>
            <div class="bbD">
                <p class="bbDP">
                    <!--保存暂时有问题-->
                    <input type="submit" value="保存" class="btn_ok btn_yes" href="connoisseur.jsp"/>
                    <a class="btn_ok btn_no" href="connoisseur.jsp">返回</a>
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