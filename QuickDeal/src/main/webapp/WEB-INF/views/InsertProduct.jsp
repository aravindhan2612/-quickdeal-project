<%@ page language="java" contentType="text/html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProductInsertion</title>	
</head>
<body>
<%@include file="Header.jsp"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<h3 align="center">Product Page</h3>
<form:form modelAttribute="product" action="InsertProduct" method="post" enctype="multipart/form-data">
<form:input class="form-control" path="productName"/>
<form:input class="form-control" path="productDesc"/>
<form:input class="form-control" path="price"/>
<form:input class="form-control" path="stock"/>
 <form:select class="form-control" path="categoryName">
             <form:option  value="0" lable="---select---"></form:option>
             <form:options items="${catlist }" lable="---select---"></form:options>
        </form:select>
         <form:select class="form-control" path="supplierName">
         <form:option  value="0" lable="---select---"></form:option>
             <form:options items="${supplierlist }" lable="---select---"></form:options>
        </form:select>
         
            <form:input class="form-control" type="file" path="pimage"/>
            <button type="submit" class="form-control">Submit</button>
            </form:form>
            
            </body>
</html>
            