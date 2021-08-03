<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Добро пожаловать</title>

    <%--style--%>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <%--WEBIX--%>
    <link type="text/css" rel="stylesheet" href="http://cdn.webix.com/components/sidebar/sidebar.css" charset="UTF-8">
<%--    <link href="${contextPath}/resources/webix/skins/mini.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/mini.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/material.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/material.css" rel="stylesheet">--%>
    <link href="${contextPath}/resources/webix/skins/flat.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/flat.css" rel="stylesheet">
<%--    <link href="${contextPath}/resources/webix/skins/contrast.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/contrast.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/compact.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/skins/compact.min.css" rel="stylesheet">--%>
    <link href="${contextPath}/resources/webix/webix.css" rel="stylesheet">
    <link href="${contextPath}/resources/webix/webix.min.css" rel="stylesheet">
    <%--WEBIX--%>

    <%--AWESOME--%>
    <link href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" rel="stylesheet">
    <%--AWESOME--%>

    <%--libs--%>
    <%--AWESOME--%>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/all.js"></script>
    <%--AWESOME--%>
    <script type="text/javascript" src="http://cdn.webix.com/components/sidebar/sidebar.js" charset="UTF-8"></script>
    <script src="${contextPath}/resources/webix/webix.js"></script>
    <script src="${contextPath}/resources/libs/stomp.min.js"></script>
    <script src="${contextPath}/resources/libs/sockjs.min.js"></script>
    <%--<script src="${contextPath}/resources/webix/webix.min.js"></script>--%>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <script src="${contextPath}/resources/libs/routie.min.js"></script>
    <script data-main="${contextPath}/resources/js/main" src="${contextPath}/resources/libs/require.min.js"></script>

</head>
<body>

<%--TODO--%>
<%--перенести в свой класс стилей--%>
<style type="text/css">
    .webix_list_item span{
        font-weight: bold;
        min-width: 100px;
        float: left;
        text-align: center;
    }
    .webix_list_item span.own{
        color:#4a4;
    }
</style>

<!-- /container -->
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">выход</a></h2>
    </c:if>
</div>
<div id="main"></div>
<!-- /container -->

<script src="${contextPath}/resources/js/util/webSocketUtil.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/libs/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/util/commonsUtil.js"></script>

<%--WEB SOCKET--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>--%>
<%--WEB SOCKET--%>

</body>
</html>
