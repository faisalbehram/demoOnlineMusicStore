
<%@include file="/template/header.jsp" %>



<!DOCTYPE html>
<html>
<head>

<title>Add Product</title>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Add Product</h1>

            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <form action="/admin/productInventory/addProductto" method="post" enctype="multipart/form-data" >
        
        <div class="form-group">
            <label for="productId">productId</label>
            <input name="productId" id="productId" class="form-Control"/>
        </div>      
                  
        <div class="form-group">
            <label for="name">Name</label>
            <input name="productName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><input type="radio" name="productCategory" id="category"
                                                             value="instrument" />Instrument</label>
            <label class="checkbox-inline"><input type="radio" name="productCategory" id="category"
                                                             value="record" />Record</label>
            <label class="checkbox-inline"><input type="radio" name="productCategory" id="category"
                                                             value="accessory" />Accessory</label>
        </div>

        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" name="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Base Price</label>
            <input type="text" name="basePrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><input type="radio" name="productCondition" id="condition"
                                                             value="new" />New</label>
            <label class="checkbox-inline"><input type="radio" name="productCondition" id="condition"
                                                             value="used" />Used</label>
        </div>

        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><input type="radio" name="productStatus" id="status"
                                                             value="active" />Active</label>
            <label class="checkbox-inline"><input type="radio" name="productStatus" id="status"
                                                             value="inactive" />Inactive</label>
        </div>

        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label>
            <input type="text" name="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <input type="text" name="productManufacturer" id="manufacturer" class="form-Control"/>
        </div>
        
        <div class="form-group">
            <label for="productImage">product Picture</label>
            <input type="file" name="productImage" id="productImage" class="form-Control" />
        </div>

        <br><br>
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
        
        </form>


        <%@include file="/template/footer.jsp" %>

</div></div>
</body>
</html>