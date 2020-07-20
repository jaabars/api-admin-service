package kg.megacom.apiadminservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "kg.megacom.apiadminservice.microservices.login_service")
@EnableDiscoveryClient
public class ApiAdminServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAdminServiceApplication.class, args);
    }

}
