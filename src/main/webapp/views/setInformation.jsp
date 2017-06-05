<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 5/3/2017
  Time: 11:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
    <meta charset="UTF-8">
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type='text/css' href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="/resources/images/cm-logo2.ico" type="image/x-icon">
    <link rel="stylesheet" href="/resources/form/css/styleForm.css">
</head>
<body>
<div class="form2">
    <p class="lead" align="center">More information about you:</p>
    <form:form modelAttribute="information" action="/registration/more-information" method="post">
        <div class="form-group">
            <form:label path="sex">Sex:</form:label>
            <form:select path="sex" class="form-control" name="sex" id="sel1">
                <form:option value="Male">Male</form:option>
                <form:option value="Female">Female</form:option>
            </form:select>
            <form:label path="phone">Phone:</form:label>
            <form:input path="phone" class="form-control" name="phone" id="phone" required="required"/>
            <form:label path="maritalStatus">Marital status:</form:label>
            <form:select path="maritalStatus" class="form-control" name="maritalStatus" id="sel2">
                <form:option value="Married">Married</form:option>
                <form:option value="Single">Single</form:option>
                <form:option value="Divorced">Divorced</form:option>
                <form:option value="Widowed">Widowed</form:option>
            </form:select>
            <form:label path="interests">Interest:</form:label>
            <form:textarea path="interests" class="form-control" rows="5" name="interests" id="interest" required="required"></form:textarea>
            <form:label path="socialStatus">Social status:</form:label>
            <form:textarea path="socialStatus" class="form-control" rows="5" name="socialStatus" id="socialStatus" required="required"></form:textarea>
            <form:button class="btn btn-primary btn-block">Set information</form:button>
        </div>
        </form:form>
</div> <!-- /form -->
<script src='/resources/jquery-1.11.1.min.js'></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
