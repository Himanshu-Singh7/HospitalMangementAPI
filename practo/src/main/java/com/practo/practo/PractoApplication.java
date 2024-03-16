package com.practo.practo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class PractoApplication {
	List<String> availableTimeSlots;
	public static void main(String[] args) {

		SpringApplication.run(PractoApplication.class, args);
	}

	@Bean
	public CommandLineRunner init() {

		return args -> {
			availableTimeSlots =  List.of("10:15 AM", "11:15 AM", "12:15 PM");
		};
	}


}
