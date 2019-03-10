<%@ page language="java" contentType="text/html"%>
<%@ include file="UserHome.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>

<h3>ProductDisplay</h3>
<c:forEach items="${productList}" var="product">
<tr>
<td>
<a href="<c:url value="/totalProductDisplay/${product.productId}"/>">
<td><img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="100" height="100"/></td>
</a>
</td>
<td>Price:${product.price}</td>
</tr>
</c:forEach>