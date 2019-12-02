<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Order Management Page</h1>

            <p class="lead">This is the Order management page.</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Customer Name</th>
                <th>Shipping Id</th>
                <th>Billing Id</th>
                <th>Total Price</th>
             </tr>
             </thead>
              <c:forEach items="${orders}" var="order">
                <tr>
                    <td>${order.customer.customerName}</td>
                    <td>${order.shippingAddress.shippingAddressId}</td>
                    <td>${order.billingAddress.billingAddressId}</td>
                    <td>${order.cart.grandTotal}</td>
                </tr>
            </c:forEach>
        </table>
	</div></div>
        <%@include file="/template/footer.jsp" %>
