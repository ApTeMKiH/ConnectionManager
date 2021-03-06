<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 5/15/2017
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="shortcut icon" href="/resources/images/cm-logo2.ico" type="image/x-icon">
    <link rel="stylesheet" href="/resources/css/myStyle.css"/>

</head>
<body>
<nav class="navbar navbar-inverse visible-xs">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Logo</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="/"><span class="glyphicon glyphicon-home"><span class="punktS">Profile</span></span></a></li>
                <li><a href="/friends"><span class="glyphicon glyphicon-user"><span class="punktS">Friends<span class="badge friendBadge"></span></span></span></a></li>
                <li><a href="/message"><span class="glyphicon glyphicon-envelope"><span class="punktS">Messages<span class="badge messageBadge"></span></span></span></a></li>
                <li><a href="/photo"><span class="glyphicon glyphicon-camera"><span class="punktS">Photo</span></span></a></li>
                <li><a href="/audio"><span class="glyphicon glyphicon-music"><span class="punktS">Audio</span></span></a></li>
                <li><a href="/radio"><span class="glyphicon glyphicon-headphones"><span class="punktS">Radio</span></span></a></li>
                <li><a href="/settings"><span class="glyphicon glyphicon-cog"><span class="punktS">Settings</span></span></a></li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/manage"><span class="glyphicon glyphicon-lock"><span class="punktS">Manage</span></span></a></li>
                </sec:authorize>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"><span class="punktS">Logout</span></span></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row content">
        <div id="rowContent" class="col-sm-3 sidenav hidden-xs">
            <div id="row_content" class="col-sm-3 sidenav hidden-xs">
                <div class="logo">
                    <img class="img-circle" src="${currentUser.avatarPath}" alt=""/>
                </div>
                <p class="lead"><sec:authorize access="hasRole('ROLE_USER')">${currentUser.name} ${currentUser.surname}</sec:authorize>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">Admin</sec:authorize></p>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="/"><span class="glyphicon glyphicon-home"><span class="punkt">Profile</span></span></a></li>
                    <li><a href="/friends"><span class="glyphicon glyphicon-user"><span class="punkt">Friends<span class="badge friendBadge"></span></span></span></a></li>
                    <li><a href="/message"><span class="glyphicon glyphicon-envelope"><span class="punkt">Messages<span class="badge messageBadge"></span></span></span></a></li>
                    <li><a href="/photo"><span class="glyphicon glyphicon-camera"><span class="punkt">Photo</span></span></a></li>
                    <li><a href="/audio"><span class="glyphicon glyphicon-music"><span class="punkt">Audio</span></span></a></li>
                    <li><a href="/radio"><span class="glyphicon glyphicon-headphones"><span class="punkt">Radio</span></span></a></li>
                    <li><a href="/settings"><span class="glyphicon glyphicon-cog"><span class="punkt">Settings</span></span></a></li>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li><a href="/manage"><span class="glyphicon glyphicon-lock"><span class="punkt">Manage</span></span></a></li>
                    </sec:authorize>
                </ul><br>
                <div class="bottom"><a href="/logout"><span class="glyphicon glyphicon-log-out"></span></a></div>
            </div>
        </div>
        <br>

        <div id="mainContain" class="col-sm-9">
            <div class="well">
                <form:form modelAttribute="information" action="/information/edit" method="post">
                    <div class="form-group">
                        <form:label path="sex">Sex:</form:label>
                        <form:select path="sex" class="form-control" name="sex" id="sel1">
                            <c:if test="${information.sex == 'Male'}">
                                <form:option selected="selected" value="Male">Male</form:option>
                            </c:if>
                            <c:if test="${information.sex != 'Male'}">
                                <form:option value="Male">Male</form:option>
                            </c:if>
                            <c:if test="${information.sex == 'Female'}">
                                <form:option selected="selected" value="Female">Female</form:option>
                            </c:if>
                            <c:if test="${information.sex != 'Female'}">
                                <form:option value="Female">Female</form:option>
                            </c:if>
                        </form:select>
                        <form:label path="phone">Phone:</form:label>
                        <form:input value="${information.phone}" path="phone" class="form-control" name="phone" id="phone"/>
                        <form:label path="maritalStatus">Marital status:</form:label>
                        <form:select path="maritalStatus" class="form-control" name="maritalStatus" id="sel2">
                            <c:if test="${information.maritalStatus == 'Married'}">
                                <form:option selected="secelted" value="Married">Married</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus != 'Married'}">
                                <form:option value="Married">Married</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus == 'Single'}">
                                <form:option selected="selected" value="Single">Married</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus != 'Single'}">
                                <form:option value="Single">Single</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus == 'Divorced'}">
                                <form:option selected="selected" value="Divorced">Married</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus != 'Divorced'}">
                                <form:option value="Divorced">Divorced</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus == 'Widowed'}">
                                <form:option selected="selected" value="Widowed">Married</form:option>
                            </c:if>
                            <c:if test="${information.maritalStatus != 'Widowed'}">
                                <form:option value="Widowed">Widowed</form:option>
                            </c:if>
                        </form:select>
                        <form:label path="interests">Interest:</form:label>
                        <form:textarea maxlength="1000" cssStyle="resize: none" path="interests" value="${information.interests}" class="form-control" rows="5" name="interests" id="interest"></form:textarea>
                        <form:label path="socialStatus">Social status:</form:label>
                        <form:textarea maxlength="1000" cssStyle="resize: none" path="socialStatus" value="${information.socialStatus}" class="form-control" rows="5" name="socialStatus" id="socialStatus"></form:textarea>
                        <form:button class="btn btn-primary" style="margin-top: 10px">Set information</form:button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/onlyBadge.js"></script>
</body>
</html>
