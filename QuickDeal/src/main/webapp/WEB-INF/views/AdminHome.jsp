<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


<nav class="navbar navbar-expand-sm bg-dark navbar-primary justify-content-center">
 
  <ul class="navbar-nav">

<c:if test="${sessionScope.loggedIn}">

<c:if test="${sessionScope.role=='ADMIN'}">
   <li class="nav-item"><a class="nav-link" href="<c:url value="/index.jsp"/>">Home</a></li>
<li class="nav-item"><a class="nav-link" href="<c:url value="/category"/>">Category</a></li>
<li class="nav-item"><a class="nav-link" href="<c:url value="/supplier"/>">Supplier</a></li>
<li class="nav-item"><a class="nav-link" href="<c:url value="/product"/>">Product</a></li>
</c:if>
</c:if>
</ul>
<font color="blue">
<a href="<c:url value="/perform_logout"/>">Logout</a>
</font>
</nav>

<H2>Admin Home</H2>

