## E-Commerce
<p>Technologies used in the construction of the project</p>
<ul>
  <li>Spring Boot</li>
  <li>H2 Database</li>
  <li>Hibernate</li>
  <li>Spring Security</li>
  <li>Spring Data</li>
  <li>Lombok</li>
  <li>JUnit</li>
  <li>Mockito</li>
</ul>

 

````
POST /api/products/add HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 148

{
    "productName": "Java10",
    "productBrand": "Kodlab",
    "productDetails": "Java Book",
    "productPrice": 49.99,
    "stock": 100
}

````
````
GET /api/products/getAll HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 175

{
    "productName": "İphone 13",
    "productBrand": "Apple",
    "productDetails": "256GB Black Color",
    "productPrice": 23949.99,
    "stock": 9
}
````

