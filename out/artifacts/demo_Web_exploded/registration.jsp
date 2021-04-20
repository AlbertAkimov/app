<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Регистрация учетной записи</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>

<body>

<div class="container">

    <form:form method="POST" modelAttribute="userForm" class="form-signin" id="registrationForm">
        <h2 class="form-signin-heading">Регистрация учетной записи</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Имя пользователя"
                            autofocus="true"/>
                <form:errors path="username"/>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Пароль"/>
                <form:errors path="password"/>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            placeholder="Повторите свой пароль"/>
                <form:errors path="passwordConfirm"/>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <div class="form-group">
                <form:input type="text" path="firstName" class="form-control" placeholder="Имя"
                            autofocus="true" name="firstName"/>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group">
                <form:input type="text" path="lastName" class="form-control" placeholder="Фамилия"
                            autofocus="true" name="lastName"/>
            </div>
        </spring:bind>


        <spring:bind path="email">
            <div class="form-group">
                <form:input type="email" path="email" class="form-control" placeholder="Почта"
                            autofocus="true" name="email"/>
            </div>
        </spring:bind>

        <spring:bind path="phone">
            <div class="form-group">
                <form:input id="phone" type="phone" path="phone" class="form-control" placeholder="Телефон"
                            autofocus="true" name="phone"/>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/libs/jquery.validate.js"></script>
<script src="${contextPath}/resources/libs/bootstrap.min.js"></script>
<script src="${contextPath}/resources/libs/jquery.maskedinput.min.js"></script>
<script src="${contextPath}/resources/js/validation.js"></script>

<script>
    $(document).ready(function () {
        $("#phone").mask("+7-(999)-999-99-99");
    })
</script>

</body>
</html>
