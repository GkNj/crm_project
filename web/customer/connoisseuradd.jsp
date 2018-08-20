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
<script language="JavaScript">
    function go()
    {
        window.history.go(-1);
    }
</SCRIPT>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a onclick="javascript:history.back(-1);">客户信息管理</a>&nbsp;-</span>&nbsp;添加客户信息
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">
            <div class="baTopNo">
                <span>客户信息添加</span>
            </div>

            <div class="baBody">
                <form action="${path}/customer.do?method=addSave" method="post">
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名称：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="text" class="input3" name="c_name"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地区: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select class="input3" name="c_area">
                            <option value="北京市">北京市</option>
                            <option value="江苏省">江苏省</option>
                            <option value="浙江省">浙江省</option>
                            <option value="上海市">上海市</option>
                            <option value="四川省">四川省</option>
                            <option value="陕西省">陕西省</option>
                            <option value="山西省">山西省</option>
                            <option value="重庆市">重庆市</option>
                            <option value="湖北省">湖北省</option>
                        </select>
                    </div>
                    <%--<div class="bbD">--%>

                        <%--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户经理: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
                        <%--<select class="input3" name="c_manager">--%>
                            <%--<c:forEach items="${roleList}" var="r">--%>
                                <%--<c:if test="${r.r_position=='客户经理'}">--%>
                                    <%--<option  value="${r.r_id}">${r.r_name}</option>--%>
                                 <%--</c:if>--%>
                            <%--</c:forEach>--%>
                        <%--</select>--%>
                    <%--</div>--%>

                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户等级: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select class="input3" name="c_class">
                            <option value="战略合作伙伴">战略合作伙伴</option>
                            <option value="合作伙伴">合作伙伴</option>
                            <option value="大客户">大客户</option>
                            <option value="重点开发客户">重点开发客户</option>
                            <option value="普通客户">普通客户</option>
                        </select>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户满意度: &nbsp;
                        <select class="input3" name="c_satifaction">
                            <option value="5">⭐⭐⭐⭐⭐</option>
                            <option value="4">⭐⭐⭐⭐</option>
                            <option value="3">⭐⭐⭐</option>
                            <option value="2">⭐⭐</option>
                            <option value="1">⭐</option>
                        </select>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户信用度: &nbsp;
                        <select class="input3" name="c_credit">
                            <option value="5">⭐⭐⭐⭐⭐</option>
                            <option value="4">⭐⭐⭐⭐</option>
                            <option value="3">⭐⭐⭐</option>
                            <option value="2">⭐⭐</option>
                            <option value="1">⭐</option>
                        </select>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;地址: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="input3" type="text" name="c_address" />
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;邮政编码：&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="input3" type="text" name="c_portcode"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电话：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="input3" type="text" name="c_tel"/>
                    </div>
                    <div class="bbD">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;网址：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="input3" type="text" name="c_website"/>
                    </div>
                    <div class="bbD">
                        <p class="bbDP">
                            <!--保存暂时有问题-->
                            <input type="submit" name="Submit" value="保存" class="btn_ok btn_yes"/>　
                            <a class="btn_ok btn_no" href="/customer.do?method=query">返回</a>
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