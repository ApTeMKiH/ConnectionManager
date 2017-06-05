<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Артем
  Date: 5/12/2017
  Time: 7:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Photo</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/myStyle.css"/>
    <link rel="stylesheet" href="/resources/css/PhotoStyle.css"/>
    <link rel="shortcut icon" href="/resources/images/cm-logo2.ico" type="image/x-icon">
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
                <button type="button" class="btn btn btn-block" onclick="document.getElementById('id01').style.display='block'">Add more photos</button>
            </div>
            <div id="id01" class="modal">
                <form id="photoAdd" action="/photo/add" method="POST" class="modal-content animate" enctype="multipart/form-data">
                    <div class="modal-header">
                    <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                    </div>
                    <div class="modal-body">
                        <input class="addImage" type="file" name="image" required/>
                    </div>
                    <div id="errorMessage" class="bg-danger"></div>
                    <div class="modal-footer">

                        <button id="addPhoto" type="submit" class="btn btn-primary">Upload</button>
                    </div>
                </form>

            </div>
            <div id="rowPhotoContent" class="row">
                <c:if test="${photos.size() == 0}">
                    <div id="haveNoFriend" class="col-sm-9"><div class="well">You don't have any photos.</div></div>
                </c:if>
                <c:if test="${photos.size() != 0}">
                <c:forEach items="${photos}" var="photo" >
                    <div class="col-sm-4 container">
                        <div class="well photoContent">
                            <img class="photo" alt="${photo.date}" data-avatar="${photo.avatar}" data-image="${photo.id}" src="${photo.path} "/>
                        </div>
                    </div>
                </c:forEach>
                </c:if>

                <div id="myModal" class="modal">
                    <span class="closePhoto">&times;</span>
                    <img class="modal-content" id="img01">
                    <div id="caption">Add coment</div>
                    <%--<div class="modal-footer">Add coment</div>--%>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<!-- Scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/myScript.js"></script>
<script src="/resources/js/photoScript.js"></script>
<script src="/resources/js/onlyBadge.js"></script>
</body>
</html>
