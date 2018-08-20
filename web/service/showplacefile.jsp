<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2018/8/18
  Time: 9:38
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
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<script language="JavaScript">
    function go()
    {
        window.history.go(-1);
    }
</SCRIPT>
<%--<script type="text/javascript">--%>

<%--function submit(id) {--%>
<%--console.log("1111",id)--%>
<%--axios.get('http://localhost:8080//serve.do?method=addHandle', {--%>
<%--params: {--%>
<%--id: id--%>
<%--}--%>
<%--})--%>
<%--.then(function (response) {--%>
<%--console.log(response);--%>
<%--})--%>
<%--.catch(function (error) {--%>
<%--console.log(error);--%>
<%--});--%>
<%--}--%>


<%--</script>--%>
<body>
<div id="pageAll">
    <div class="pageTop">
        <div class="page">
            <img src="../base/img/coin02.png"/><span><a href="#">首页</a>&nbsp;-&nbsp;<a
                href="#">客户服务管理</a>&nbsp;-</span>&nbsp;服务处理
        </div>
    </div>
    <div class="page ">
        <!-- 上传广告页面样式 -->
        <div class="banneradd bor">

            <div class="baTopNo">
                <span>反馈处理</span>
            </div>
            <div class="cfD" style="margin-top: 30px;margin-left: 50px">

                <table width="90%">

                    <c:forEach items="${list}" var="ser">
                        <form action="/serve.do?method=addResult&id=${ser.s_id}&h_id=${handle.h_id}" method="post">
                            <div class="cfD" style="left: 560px ;top:90px ;position: absolute">

                                <input type="button" style="float: right; width: 135px;height: 30px;border: none;font-size: 16px;color: #fff;background-color: #47a4e1;"
                                       name="Submit" onclick="javascript:history.back(-1);" value="返回"><br>

                            </div>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">
                                    编号
                                </td>
                                <td width="30%" class="tdColor" style="color: black">${ser.s_id}</td>
                                <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">服务类型
                                </td>
                                <td width="40%" class="tdColor" style="color: black">咨询</td>
                            </tr>

                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">
                                    概要
                                </td>
                                <td width="30%" colspan="3" class="tdColor"
                                    style="color: black;text-align: center">${ser.s_detail}</td>
                            </tr>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">
                                    客户
                                </td>
                                <td width="30%" class="tdColor" style="color: black">${ser.customer.c_name}</td>
                                <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">状态</td>
                                <td width="40%" class="tdColor" style="color: black">${ser.s_state}</td>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">
                                    服务请求
                                </td>
                                <td width="30%" colspan="3" class="tdColor"
                                    style="color: black;text-align: center">${ser.s_request}</td>
                            </tr>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">创建人
                                </td>
                                <td width="30%" class="tdColor" style="color: black">${ser.role.r_name}</td>
                                <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">创建时间
                                </td>
                                <td width="40%" class="tdColor" style="color: black">${ser.s_time}</td>
                            <tr>

                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">分配给
                                </td>
                                <td width="30%" class="tdColor" style="color: black">${ser.s_disposeman}</td>
                                <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">分配时间
                                </td>
                                <td width="40%" class="tdColor" style="color: black">${ser.s_date}</td>
                            <tr>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">
                                    服务处理
                                </td>
                                <td colspan="3" width="50%" class="tdColor" style="color: black;">${handle.h_handle}</td>
                            </tr>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">处理人
                                </td>
                                <td width="30%" class="tdColor" style="color: black">${sessionScope.login_name}
                                </td>
                                <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">处理时间
                                </td>
                                <td width="40%" class="tdColor" style="color: black">${handle.h_time}
                                </td>
                            <tr>
                            <tr>
                                <td width="100px" class="tdColor tdC" style="background-color: #47a4e1;color: black">
                                    处理结果
                                </td>
                                <td width="30%" class="tdColor" style="color: black"><input type="text" name="result" value="${handle.h_result}">
                                </td>
                                <td width="100px" class="tdColor" style="background-color: #47a4e1;color: black">满意度
                                </td>
                                <td width="40%" class="tdColor" style="color: black"><c:if test="${handle.h_stai==5}">⭐⭐⭐⭐⭐</c:if>
                                    <c:if test="${handle.h_stai==4}">⭐⭐⭐⭐</c:if>
                                    <c:if test="${handle.h_stai==3}">⭐⭐⭐</c:if>
                                    <c:if test="${handle.h_stai==2}">⭐⭐</c:if>
                                    <c:if test="${handle.h_stai==1}">⭐</c:if>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </table>

            </div>
        </div>

        <!-- 上传广告页面样式end -->
    </div>
</div>
</body>
</html>

