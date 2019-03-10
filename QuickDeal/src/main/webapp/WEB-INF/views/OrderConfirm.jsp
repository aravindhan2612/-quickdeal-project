<%@ page language="java" contentType="text/html"%>
<%@ include file="UserHome.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
<td colspan="5"><center> Your Order</center></td>
<tr bgcolor="orange">
<td>Image</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>
<td>Operation</td>
</tr>
<c:forEach items="${listCartItem }" var="cartItem">
<form action="<c:url value="/updateCartItem/${cartItem.cartId}"/>" method="get">
<tr>
<td><img  src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>" width=50 height=50/></td>
<td>${ cartItem.productName}</td>
<td>${cartItem.quantity }</td>
<td>${cartItem.price}</td>
<td>${cartItem.quantity*cartItem.price}</td>
<td>
<input type="submit" value="update" class="btn btn-success"/>
<a  class="btn btn-danger" href="<c:url value="/deleteCartItem/${cartItem.cartId }"/>">Delete</a>
</td>

</tr>
</form>
</c:forEach>
<tr bgcolor="pink">
<td colspan="4">Grand Total Price</td>
<td colspan="2">${grandTotal}/-</td>
</tr>
<tr>
<td colspan="2">Address</td>
<td colspan="4">
          <textarea name="address" id="address" cols="30" rows="5">${addr}</textarea>
          </td>
          </tr>
          <td colspan="4"><center><a href="<c:url value="/updateAddress"/>">Update</a></center></td>
<tr bgcolor="green">
<td colspan="3"><center><a href="<c:url value="/productDisplay"/>">Continue Shopping</a></center></td>
<td colspan="3"><center><a href="<c:url value="/payment"/>">Payment</center></td>
</tr>

</table>

