<%-- 
    Document   : inventory
    Created on : Feb 28, 2016, 3:15:08 PM
    Author     : Takahashi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Inventory --> 

<%@page import = "edu.lcc.citp.inventory.InventoryManager" %>
<jsp:useBean id = "inventoryManger" scope= "application"
             class = "edu.lcc.citp.inventory.InventoryManager"></jsp:useBean>

<head>
	<title>Inventory Form</title>
</head>
<body>
	<div>
		<h1>Inventory Form</h1>
	</div>
    
	<div>
		<form action="inventory" method="post">
                    
                    
                    
                    
                    
			<div>
				<label for="upc">UPC</label>
				<input type="text" id="upc" name="upc" />
			</div>
                   
     <c:forEach var="p" items="${productManager.productList}">
                    <div>
                        <form action="inventory" method="POST">
                            <label>
                                <span>UPC</span>
                                <input type="text" name="upc" value="${p.getUpc()}" readonly="readonly"/>
                            </label>
                            <label>
                                <span>Short Details</span>
                                <input type="text" name="shortDetails" value="${p.getShortDetails()}" />
                            </label>
                            <label>
                                <span>Long Details</span>
                                <input type="text" name="longDetails" value="${p.getLongDetails()}" />
                            </label>
                            <label>
                                <span>Price</span>
                                <input type="text" name="price" value="${p.getPrice()}" />
                            </label>
                            <label>
                                <span>Stock</span>
                                <input type="text" name="stock" value="${p.getStock()}" />
                            </label>
                            <input type="submit" name="button" value="Edit" />
                            <input type="submit" name="button" value="Delete" />
                        </form>
                    </div>
                </c:forEach>
			<div>
				<label for="shortDetails">Short Details</label>
				<input type="text" id="shortDetails" name="shortDetails" />
			</div>
			<div>
				<label for="longDetails">Long Details</label>
				<input type="text" id="longDetails" name="longDetails" />
			</div>
			<div>
				<label for="price">Price</label>
				<input type="text" id="price" name="price" />
			</div>
			<div>
				<label for="stock">Stock</label>
				<input type="text" id="stock" name="stock" />
			</div>
			<div>
				<input type="submit" value="Create" name="button" />
			</div>
		</form>
	</div>
</body>
</html>