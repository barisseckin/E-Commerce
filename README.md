## E-Commerce
<p>Technologies used in the construction of the project</p>
<ul>
  <li>Spring Boot</li>
  <li>H2 Databse</li>
  <li>Hibernate</li>
  <li>Spring Data</li>
  <li>Lombok</li>
  <li>JUnit</li>
</ul>

<h3> Some available services </h3>

<ul>
  <li>On the product side</li>
  <ul>
      <li>Add product</li>
      <li>Search product</li>
      <li>Delete product</li>
      <li>Search options by brand and id</li>
    </ul>
  <li>On the user side</li>
  <ul>
      <li>Add user</li>
      <li>Delete user</li>
    <li>Search user</li>
  </ul>  
  
</ul>  

````
POST /api/products/add HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Content-Length: 148

{
    "productName": "Java10",
    "productBrand": "Kodlab",
    "productDetails": "Java Egitim Seti",
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
    "productDetails": "256GB Black Color Apple Türkiye Garantili",
    "productPrice": 1949.99,
    "stock": 9
}
````

