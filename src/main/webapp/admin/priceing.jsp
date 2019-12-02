<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/template/header.jsp"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>



<div class="container-wrapper">
    <div class="container">
   
   	 <table class="table table-striped table-hover">
   	 
   	 <thead>
            <tr class="bg-success">
                <th>Product Name</th>
                <th>Price</th>
                <th> Discount Percentage</th>
                <th> Discount Price</th>  
            </tr>
            </thead>
             
            <c:forEach items="${products}" var="product" >	
            
            <tr>            		
            				 
            				
            				<td>  
						  ${product.productName}
						   	 </td>  
						   	 <c:forEach items="${listOfBasePrices}" var="basicprice"> 
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
					
				
					
		            		       
            </tr>
            </c:forEach>
            <tr bgcolor="#00ff00"	>
            
            <c:if test="${not empty genericDiscount}">
            	<td  bgcolor="#00ff00">the Generic Discount is</td>
            	<td></td>
            	<td>${ genericDiscount.get().percentageDiscount} </td>
            	<td></td>
            </c:if>
                     
            </tr> 
   	  
   	 </table>
   
   
       <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                <th>Discount</th>
                <th>All Products / Name</th>
                <th>Update Discount</th>
                <th>Disable Discount</th>  
            </tr>
            </thead>
           
          
            <tr>
            <form action="/admin/updateDiscount">
           
            <td>
            	<input type="text" name= "discount" >
            </td>
     
             
             <td>
            	<select name="allProduct">
            	<option  value="all"  selected="selected">All Product</option>
            		 
            		  <c:forEach items="${products}" var="product">		  
				  
				  <option value="${product.productId}"> ${product.productName} </option>
				   	
				   	 </c:forEach> 
				</select>
				
            </td>
            
            <td><input type="submit" value="Update"></td>
            	
            <td>	
              </form>
              
              <form action="/admin/disableDiscount">
            	<select name="priceId">
            	<option  value="all"  selected="selected">All Product</option>
            		 
            		  <c:forEach items="${discountPrices}" var="discountPrice">		  
				  
				  <option value="${discountPrice.id}"> ${discountPrice.product.productName} </option>
				   	
				   	 </c:forEach> 
				</select>
            	 <td><input type="submit" value="Disable"></td>
            	</form></td>
            </tr>
          
           
        </table>
   
     
       <%@include file="/template/footer.jsp" %>

</div></div>
<%-- 
<select name="productId">
   <c:forEach items="${products}" var="product">
           
	        
		  	 <option value="${product.productId}">${product.productId}</option>
 
                    <td>${product.productId}</td>
                    
                    <td><a href="<spring:url value="/viewProduct/${product.productId}" />"
                    ><span class="glyphicon glyphicon-info-sign"></span></a></td>
                </c:forEach>
                 </select>
	     </form> --%>