package com.example.javajwtdemo;

import com.example.javajwtdemo.auth.AuthenticationService;
import com.example.javajwtdemo.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static com.example.javajwtdemo.enums.Role.*;

@SpringBootApplication
public class JavaJwtDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaJwtDemoApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			//Admin
			var admin = RegisterRequest.builder()
					.name("Admin")
					.email("Admin@gmail.com")
					.password("123")
					.phone("0392272536")
					.status(true)
					.role(ADMIN)
					.build();
			System.out.println("Admin token :" + service.register(admin).getAccessToken());

			//staff
			var staff = RegisterRequest.builder()
					.name("Staff")
					.email("staff@gmail.com")
					.status(true)
					.password("123")
					.phone("0854512367")
					.role(STAFF)
					.build();
			System.out.println("Creator token :" + service.register(staff).getAccessToken());

			//Customer
			var customer = RegisterRequest.builder()
					.name("Trần Huy")
					.email("huypt110402@gmail.com")
					.status(true)
					.password("123")
					.phone("0854512367")
					.role(CUSTOMER)
					.build();
			System.out.println("Customer token :" + service.register(customer).getAccessToken());

			var customer2 = RegisterRequest.builder()
					.name("Huyền Trân")
					.email("tran123@gmail.com")
					.status(true)
					.password("123")
					.phone("0854512367")
					.role(CUSTOMER)
					.build();
			service.register(customer2);

		};
	}

}
