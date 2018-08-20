<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>行家-有点</title>
    <link rel="stylesheet" type="text/css" href="../base/css/css.css" />
    <script type="text/javascript" src="../base/js/jquery.min.js"></script>
</head>
<SCRIPT language=javascript>
    function go()
    {
        window.history.go(-1);
    }
</SCRIPT>

<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;编辑客户信息
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">
            <form action="${path}/customer.do?method=update&cId=${requestScope.customer.c_id}" method="post">
            <div class="baTopNo">
                <span>客户信息编辑</span>
            </div>
            <div class="baBody">
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text" class="input3" name="c_name" value="${requestScope.customer.c_name}"/>

            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地区: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select class="input3" name="c_area"  >

                    <option value="北京市" <c:if test="${requestScope.customer.c_area=='北京市'}">selected</c:if> >北京市</option>
                    <option value="江苏省" <c:if test="${requestScope.customer.c_area=='江苏省'}">selected</c:if> >江苏省</option>
                    <option value="浙江省" <c:if test="${requestScope.customer.c_area=='浙江省'}">selected</c:if> >浙江省</option>
                    <option value="上海市" <c:if test="${requestScope.customer.c_area=='上海市'}">selected</c:if> >上海市</option>
                    <option value="四川省" <c:if test="${requestScope.customer.c_area=='四川省'}">selected</c:if> >四川省</option>
                    <option value="陕西省" <c:if test="${requestScope.customer.c_area=='陕西省'}">selected</c:if> >陕西省</option>
                    <option value="山西省" <c:if test="${requestScope.customer.c_area=='山西省'}">selected</c:if> >山西省</option>
                    <option value="重庆市" <c:if test="${requestScope.customer.c_area=='重庆市'}">selected</c:if> >重庆市</option>
                    <option value="湖北省" <c:if test="${requestScope.customer.c_area=='湖北省'}">selected</c:if> >湖北省</option>
                </select>
            </div>

            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户等级: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <select class="input3" name="c_class">
                    <option value="战略合作伙伴" <c:if test="${requestScope.customer.c_class=='战略合作伙伴'}">selected</c:if> >战略合作伙伴</option>
                    <option value="合作伙伴" <c:if test="${requestScope.customer.c_class=='合作伙伴'}">selected</c:if> >合作伙伴</option>
                    <option value="大客户" <c:if test="${requestScope.customer.c_class=='大客户'}">selected</c:if> >大客户</option>
                    <option value="重点开发客户" <c:if test="${requestScope.customer.c_class=='重点开发客户'}">selected</c:if> >重点开发客户</option>
                    <option value="普通用户" <c:if test="${requestScope.customer.c_class=='普通客户'}">selected</c:if> >普通客户</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户满意度: &nbsp;
                <select class="input3" name="c_satifaction">
                    <option value="5" <c:if test="${requestScope.customer.c_satifaction==5}">selected</c:if> >⭐⭐⭐⭐⭐</option>
                    <option value="4" <c:if test="${requestScope.customer.c_satifaction==4}">selected</c:if> >⭐⭐⭐⭐</option>
                    <option value="3" <c:if test="${requestScope.customer.c_satifaction==3}">selected</c:if> >⭐⭐⭐</option>
                    <option value="2" <c:if test="${requestScope.customer.c_satifaction==2}">selected</c:if> >⭐⭐</option>
                    <option value="1" <c:if test="${requestScope.customer.c_satifaction==1}">selected</c:if> >⭐</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户信用度: &nbsp;
                <select class="input3" name="c_credit" >
                    <option value="5" <c:if test="${requestScope.customer.c_credit==5}">selected</c:if> >⭐⭐⭐⭐⭐</option>
                    <option value="4" <c:if test="${requestScope.customer.c_credit==4}">selected</c:if> >⭐⭐⭐⭐</option>
                    <option value="3" <c:if test="${requestScope.customer.c_credit==3}">selected</c:if> >⭐⭐⭐</option>
                    <option value="2" <c:if test="${requestScope.customer.c_credit==2}">selected</c:if> >⭐⭐</option>
                    <option value="1" <c:if test="${requestScope.customer.c_credit==1}">selected</c:if> >⭐</option>
                </select>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" name="c_address" value="${requestScope.customer.c_address}"/>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" name="c_portcode" value="${requestScope.customer.c_portcode}"/>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" name="c_tel" value="${requestScope.customer.c_tel}"/>
            </div>
            <div class="bbD">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="input3" type="text" name="c_website" value="${requestScope.customer.c_website}"/>
            </div>
            <%--<div class="bbD">--%>
            <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户状态：--%>
            <%--<label><input type="radio" checked="checked" name="styleshoice1" />&nbsp;正常</label>--%>
            <%--<label><input type="radio" name="styleshoice1" />&nbsp;已流失</label>--%>
            <%--</div>--%>
            <div class="bbD">
                <p class="bbDP">
                    <!--保存暂时有问题-->
                    <input type="submit" name="Submit" value="保存" class="btn_ok btn_yes" />
                    <input type="button" class="btn_ok btn_no" name="Submit" onclick="javascript:history.back(-1);" value="返回">
                    <%--<a class="btn_ok btn_no" href="connoisseur.jsp">返回</a>--%>
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