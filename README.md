## E-Commerce
<p>Technologies used in the construction of the project</p>
<ul>
  <li>Spring Boot</li>
  <li>H2 Database</li>
  <li>MySQL Database</li>
  <li>Hibernate</li>
  <li>Spring Security</li>
  <li>Spring Data</li>
  <li>Lombok</li>
  <li>JUnit</li>
  <li>Mockito</li>
<li>Spring Mail Sender</li>
</ul>

<img src="https://icon-library.com/images/java-icon-png/java-icon-png-15.jpg" style="height: 50px">
<img src="https://www.svgrepo.com/show/354380/spring-icon.svg" style="height: 40px">
<img src="https://www.freepnglogos.com/uploads/logo-mysql-png/logo-mysql-mysql-logo-png-images-are-download-crazypng-21.png" style="height: 40px">
<img src="https://design.jboss.org/hibernate/logo/final/hibernate_logo_whitebkg_stacked_256px.png" style="height: 40px">
<img src="https://pbs.twimg.com/profile_images/1235983944463585281/AWCKLiJh_400x400.png" style="height: 40px">

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

<p>
For user actions, you need to set the mail configuration settings from the application.properties file. 
</p>

