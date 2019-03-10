<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>QuickDeal</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-primary justify-content-center">
 
  <ul class="navbar-nav">
    
   
    <li class="nav-item"><a class="nav-link" href="<c:url value="/login"/>">Login</a></li>
    <li class="nav-item"><a class="nav-link" href="<c:url value="/register"/>">Register</a></li>
    <li class="nav-item"><a class="nav-link" href="<c:url value="/index.jsp"/>">Home</a></li>
    <li class="nav-item"><a class="nav-link" href="<c:url value="/aboutus"/>">AboutUs</a></li>
    <li class="nav-item"><a class="nav-link" href="<c:url value="/contactus"/>">ContactUs</a></li>


</ul>  

</nav>
</body>
</html>