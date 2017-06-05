<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 5/3/2017
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type='text/css' href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="/resources/images/cm-logo2.ico" type="image/x-icon">
    <link rel="stylesheet" href="/resources/form/css/styleForm.css">
</head>
<body>
<div class="form">
    <p class="lead" align="center">Sign in</p>
    <form id="login" action="/sign-in" method="post">
        <div class="form-group">
            <label for="email">Email:</label>
            <input class="form-control" type="text" name="username" id="email" required/>
            <label for="password">Password:</label>
            <input class="form-control" type="password" name="password" id="password" required/>
            <button id="signIn" type="submit" class="btn btn-primary btn-block">Sign in</button>
        </div>
    </form>
    <c:if test="${error != null}">
        <div id="errorMessage" style="display: block" class="bg-danger">${error}</div>
    </c:if>
    <c:if test="${info != null}">
        <div id="errorMessage" style="display: block; background-color: #5bc0de" class="bg-info">${info}</div>
    </c:if>
    <p class="info">If you don't have an account just <a href="/registration">sign up</a>.</p>
</div> <!-- /form -->
<script src='/resources/jquery-1.11.1.min.js'></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/signInScript.js"></script>
</body>
</html>
