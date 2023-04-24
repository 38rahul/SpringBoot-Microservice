package net.javaguides.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Department Service Rest APIs",
				description = "Department Service Rest Api's Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Rahul",
						email = "r.rajput.tiu97@gmail.com",
						url = "github.com/38rahul"
				),
				license = @License(
						name = "Apache 2.0",
						url = "github.com/38rahul"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Department -Service Doc",
				url = "github.com/38rahul"
		)
)
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
