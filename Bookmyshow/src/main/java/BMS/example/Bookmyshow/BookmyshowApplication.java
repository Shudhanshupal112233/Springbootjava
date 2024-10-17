package BMS.example.Bookmyshow;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@OpenAPIDefinition
public class BookmyshowApplication {

	public static void main(String[] args) {

		SpringApplication.run(BookmyshowApplication.class, args);
		System.out.println("hello");
	}

}
