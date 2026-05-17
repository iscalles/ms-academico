package ms_academico.academicoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AcademicoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcademicoServiceApplication.class, args);
	}

}
