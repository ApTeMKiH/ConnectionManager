<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title><sec:authorize access="hasRole('ROLE_USER')">${currentUser.name}</sec:authorize>
        <sec:authorize access="hasRole('ROLE_ADMIN')">Admin</sec:authorize></title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/myStyle.css"/>
    <link rel="stylesheet" href="/resources/css/profileAvatar.css"/>
    <link rel="stylesheet" href="/resources/css/PostStyle.css"/>
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
            <div class="row clearfix">
                <div class="col-sm-4">
                    <div class="well" id="wellImg" onmouseover="showBtn()" onmouseleave="hideBtn()">
                        <img id="avatarImg"  src="${currentUser.avatarPath}" class="img-rounded photo" alt="${avatarDate}">
                        <button id="addAvatar" class='btn btn-xs' onclick="document.getElementById('id01').style.display='block'">Change avatar</button>
                    </div>
                </div>
                <div id="myModal" class="modal">
                    <span class="closePhoto">&times;</span>
                    <img class="modal-content" id="img01">
                    <div id="caption"></div>
                    <%--<div class="modal-footer">Add coment</div>--%>
                </div>
                <div class="col-sm-8">
                    <div class="well" id="infoUser">
                        <span class="nameMain"><strong>${currentUser.name} ${currentUser.surname}</strong></span><br><br>
                        <span><strong>Sex:</strong></span><pre class="preInfo">${information.sex}</pre>
                        <span><strong>Phone:</strong></span><pre class="preInfo">${information.phone}</pre>
                        <span><strong>Marital status:</strong></span><pre class="preInfo">${information.maritalStatus}</pre>
                        <span><strong>Interests:</strong></span><pre class="preInfo">${information.interests}</pre>
                        <span><strong>Social status:</strong></span><pre class="preInfo">${information.socialStatus}</pre>
                    </div>
                </div>
            </div>
            <div id="id01" class="modal">
                <form id="photoAdd" action="/add/avatar" method="POST" class="modal-content animate" enctype="multipart/form-data">
                    <div class="modal-header">
                        <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
                    </div>
                    <div class="modal-body">
                        <input id="addImage" class="addImage" type="file" name="image" required/>
                        <div id="errorMessage" class="bg-danger"></div>
                    </div>
                    <div class="modal-footer">
                        <button id="addPhoto" type="submit" class="btn btn-primary">Upload</button>
                    </div>
                </form>

            </div>
            <c:if test="${photo.size() != 0}">
                <div class="slideshow-container">
                <c:forEach items="${photo}" var="photo">
                <div class="mySlides ">
                    <img class="clideshow" src="${photo.path}" style="width:100%">
                    <div class="text">${photo.date.toString().substring(0,photo.date.toString().length()-5)}</div>
                </div>
                <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
                <a class="next" onclick="plusSlides(1)">&#10095;</a>
                </c:forEach>
                </div>
            </c:if>

            <div class="form-group" style="margin-top: 20px">
                <form:form modelAttribute="newPosts" method="post" action="/posts/add">
                    <form:label path="text">Add new post:</form:label>
                    <form:textarea maxlength="1000" class="form-control" id="newPost" path="text" rows="4"></form:textarea>
                    <form:button class="btn btn-primary">Add new post</form:button>
                </form:form>
            </div>
            <div class="well posts">

                <c:if test="${posts.size() == 0}">
                <div class="container" style="margin: auto; width: 100%"><p style="text-align: center">You don't have any posts.</p></div>
                </c:if>
                <c:if test="${posts.size() != 0}">
                    <c:forEach items="${posts}" var="post" >
                        <div class="container">
                            <img src="${post.author.avatarPath}" alt="Avatar" style="width:90px">
                            <c:if test="${currentUser.id == post.author.id}">
                                <p><span><a href="/">${post.author.name} ${post.author.surname}</a></span> ${post.date.toString().substring(0,post.date.toString().length()-5)}</p>
                            </c:if>
                            <c:if test="${currentUser.id != post.author.id}">
                                <p><span><a href="/friend/profile/${post.author.id}">${post.author.name} ${post.author.surname}</a></span> ${post.date.toString().substring(0,post.date.toString().length()-5)}</p>
                            </c:if>
                            <p id="postText${post.id}">${post.text}</p>
                            <form:form modelAttribute="newPosts" action="" method="post" class="changePostForm" id="changePostForm${post.id}" >
                                <form:label path="text" id="changeText">Change your post:</form:label>
                                <form:textarea maxlength="1000" path="text" name="text" rows="5" class="form-control" id="textAreaPost${post.id}"></form:textarea>
                                <form:button data-post="${post.id}" class="btn btn-primary btn-xs btnSubmit">Submit</form:button>
                            </form:form>
                            <%--<div class="btn-group" id="btnGroup">--%>
                                <c:if test="${currentUser.id == post.author.id}">
                                    <a class="btnEdit" data-post="${post.id}" href="/posts/edit/${post.id}"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a class="btnDelete" href="/posts/delete/${post.id}"><span class="glyphicon glyphicon-remove"></span></a>
                                </c:if>
                                <c:if test="${currentUser.id != post.author.id}">
                                    <a class="btnDelete" href="/posts/delete/${post.id}"><span class="glyphicon glyphicon-remove"></span></a>
                                </c:if>
                            <%--</div>--%>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<!-- Scripts -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/js/myScript.js"></script>
<script src="/resources/js/profileAvatar.js"></script>
<script src="/resources/js/PostsScript.js"></script>
<script src="/resources/js/onlyBadge.js"></script>
</body>
</html>
