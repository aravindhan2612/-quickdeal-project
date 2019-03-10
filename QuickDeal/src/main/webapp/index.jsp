<%@ page language ="java" contentType="text/html"%>
<%@ include file="/WEB-INF/views/Header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>


<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<style>
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  </style>
</head>
<body>
<div class="container-fluid">
<div id="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
    <li data-target="#demo" data-slide-to="3"></li>
  </ul> 
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="<c:url value="/resources/images/assus rog 2.jpg"/>" alt="shop" >
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/images/asusrog.1.jpg"/>" alt="shopi" >
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/images/helio 300 1.jpg"/>" alt="hifi" >
    </div>
    <div class="carousel-item">
      <img src="<c:url value="/resources/images/MSI 1.jpg"/>" alt="New" >
    </div>
  </div>
  
 
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

  </div>
</body>
</html>

