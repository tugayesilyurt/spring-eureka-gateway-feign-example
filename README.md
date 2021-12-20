# Docker Compose Spring Eureka,Spring Cloud API Gateway,FeignClient Example

## Run the System
We can easily run the whole with only a single command:

* `docker-compose up`

The services can be run on the background with command:

* `docker-compose up -d`


## Stop the System
Stopping all the running containers is also simple with a single command:

* `docker-compose down`


If you need to stop and remove all containers, networks, and all images used by any service in <em>docker-compose.yml</em> file, use the command:

* `docker-compose down --rmi all`

### EndPoints ###

| Service       | EndPoint                               | Method | Description                                      |
| ------------- | -----------------------------          | :-----:| ------------------------------------------------ |
| Customer      | /api/v1/customer/order/{customerid}    | GET    | Return customer order detail               	     |
| Product       | /api/v1/product/{id}              	 | GET    | Return product detail                      	 |

customer-service microservice connect to product-service via **Feign**

- **Eureka**

You can open Eureka : http://localhost:8761
username:admin
password:admin

![Eureka](https://github.com/tugayesilyurt/spring-eureka-gateway-feign-example/blob/main/assets/eureka.PNG)
	
- **Postman**

![Postman](https://github.com/tugayesilyurt/spring-eureka-gateway-feign-example/blob/main/assets/postman.PNG)