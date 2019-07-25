# execise be

Good Service 


## Overview

The service exposes two endpoints as described in swagger api idl

- /v1/good/order -> build the order on goods in request body
- /v1/good/category -> get good categories known by the service   

## Framework
  
The service is developed using spring-boot framework with swagger for api design and base code generation 
The Data Model is represented by an Entity called "Category" which describes all the good categories with a specific tax rate 

You can view the api documentation in swagger-ui by pointing to  
http://localhost:8080/  

Change default port value in application.properties
