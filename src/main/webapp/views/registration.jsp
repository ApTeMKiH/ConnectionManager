<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 4/20/2017
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta charset="UTF-8">
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type='text/css' href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="/resources/images/cm-logo2.ico" type="image/x-icon">
    <link rel="stylesheet" href="/resources/form/css/styleForm.css">
</head>
<body>
<div class="form">
    <p class="lead" align="center">Sign up</p>
    <form:form modelAttribute="user" action="/registration" method="post">
        <div class="form-group">
            <form:label path="name">Name:</form:label>
            <form:input path="name" class="form-control" name="name" id="name" />
            <form:label path="surname">Surname:</form:label>
            <form:input path="surname" class="form-control" name="surname" id="surname" />
            <form:label path="email">Email:</form:label>
            <form:input path="email" class="form-control" name="email" id="email" required="required"/>
            <form:label path="password">Password:</form:label>
            <form:password path="password" class="form-control" name="password" id="password" required="required"/>
            <form:button class="btn btn-primary btn-block" id="send">Sign up</form:button>
        </div>
    </form:form>
    <div id="errorMessage" class="bg-danger"></div>
    <div style="text-align: center; margin-top: 10px" class="bg-info">After registration check your email for activate</div>
    <p class="info">If you have an account just <a href="/sign-in">sign in</a>.</p>
</div> <!-- /form -->
<script src='/resources/jquery-1.11.1.min.js'></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/myScript.js"></script>
</body>
</html>
