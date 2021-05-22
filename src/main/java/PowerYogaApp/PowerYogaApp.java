package PowerYogaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "PowerYogaApp")
@SpringBootApplication
public class PowerYogaApp {
	
	public static void main(String[] args) {
		SpringApplication.run(PowerYogaApp.class,args);

	}


}
