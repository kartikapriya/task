Shopping Cart Implementation with RestAPI

Used below technologies:
-SpringBoot
-SpringDataJPA
-MySQL

Requirements:
-Create Database testdb
-Check for the tables:
 1.shopping_cart
 2.user
 3.product

Resource endpoints:

-Retrieve a list of products avaialable:
 http://localhost:8080/products

-To Insert/Update the products into the cart, Provide value of productId and quantity
 http://localhost:8080/ShoppingCart [method POST]
 
 http://localhost:8080/ShoppingCart/{id}  [pass the shoppingId value & method PUT]

-To empty the cart and delete specific shopping id [method DELETE]
 http://localhost:8080/ShoppingCart
 http://localhost:8080/ShoppingCart/{id}

-Retrieve a list of products in the cart [method GET]:
 http://localhost:8080/ShoppingCart

-To purchase the Items, pass the shoppingId value
 http://localhost:8080/ShoppingCart/purchase/{id}

-Retrieve the history of products purchased
 http://localhost:8080/history
