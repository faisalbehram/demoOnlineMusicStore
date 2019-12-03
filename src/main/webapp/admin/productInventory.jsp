<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/template/header.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Inventory Page</h1>

            <p class="lead">This is the product inventory page!</p>
        </div>
         <form action="/admin/searchproduct" class="form-inline">
	        <div class="form-group mb-2">
	         <input type="text" class="form-control" name="productName" placeholder="Search products" />
	         <input type="submit" value="Search"  class="btn btn-primary"/>
	        </div>
	     </form>
 <a href="/admin/productInventory/addProduct" class="btn btn-primary">Add Product</a>
        
        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Photo Thumb</th>
                <th>Product Name</th>
                <th>Category</th>
                <th>Condition</th>
                <th>Price</th>
                <th>Discounted Percentage</th>
                 <th>Discounted Price</th>
              
            </tr>
            </thead>
            
             <c:forEach items="${products}" var="product">	
            
            <tr>            
            <td><img src="<c:url value="/resources/images/${product.productId}.png" /> " alt="image" style="width:100%"/></td>	
                    <td>${product.productName}</td>
                    
                    <td>${product.productCategory}</td>
                    <td>${product.productCondition}</td>		
       
			 <c:forEach items="${basicPrice}" var="basicprice"> 
                  		<c:if test="${basicprice.product.productId == product.productId }">
             				<td>${basicprice.price}</td>
             			</c:if>	          
           			 </c:forEach>  
            
            
		            <c:forEach items = "${discountPrices }" var="discountPrice">
		            
		          	<c:if test="${discountPrice.product.productId == product.productId }">
		           		 <td>  	
						  ${discountPrice.percentageDiscount}
						  </td>
						  <c:forEach items = "${discounts }" var="discount">
						  
						  <c:if test="${
											  discount.proId.productId == discountPrice.product.productId }">
						   <td>  	
						  ${discount.discountPrice}
						  </td>
						  </c:if>
						  	</c:forEach>
						 
						 
					</c:if>
					
					
				
					</c:forEach>
		            	<td><a href="<spring:url value="/viewProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a>
                     <a href="<spring:url value="/admin/productInventory/delete/${product.productId}/" />"
                    ><span class="glyphicon glyphicon-remove"></span></a>
                    
                    <a href="<spring:url value="/admin/editProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-edit"></span></a></td>	       
            </tr>
            </c:forEach>
   
                
        </table>
        

       
        </div>

        <%@include file="/template/footer.jsp" %>
        </div>
        
