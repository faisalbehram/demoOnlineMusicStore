<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<%@include file="/template/header.jsp" %>

<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

<body>
<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Cart</h1>

                    <p>All the selected products in your shopping cart</p>
                </div>
            </div>
        </section>

        <section class="container">
            <div >
            <div>
                <a href="/cart/clear/${cartId}"><span
                        class="glyphicon glyphicon-remove-sign"></span>Clear Cart</a>
				
				 
              	<c:choose>
                   		<c:when test="${item.quantity != '0'}">
                <a href="<spring:url value="/checkout/${cartId}"/>"
                   class="btn btn-success pull-right"><span class="glyphicon-shopping-cart glyphicon"></span> Check out
                </a>
                    </c:when>
                    </c:choose>
            </div>

            <table class="table table-striped border border-info">
                <tr class ="p-3 mb-2 bg-info text-white ">
                    <th>Product</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
        <c:forEach items="${items}" var="item">
       <tr class ="p-3 mb-2 bg-info text-white ">
           <td><c:out value="${item.product.productName}"/></td>
           <td><c:out value="${item.product.price2.get(0).price}"/></td>
             <td><c:out value="${item.quantity}"/></td>
            	<td><c:out value = "${item.totalPrice}"/></td>
				<td><a href="/cart/remove/${item.cartItemId}" 
				 class="label label-danger" >
               <span class="glyphicon glyphicon-remove"></span>remove</a></td>
        </tr>
    </c:forEach>
                
            </table>
            

            <a href="<spring:url value="/" />" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>

    </div>
</div>


</body>
</html>

<%@include file="/template/footer.jsp" %>