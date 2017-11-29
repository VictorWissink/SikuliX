package nl.oldenzaal.testprototypes.sikulix;

import nl.oldenzaal.testprototypes.sikulix.configuration.JpaConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"nl.oldenzaal.testprototypes.sikulix"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootCRUDApp {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootCRUDApp.class, args);
	}
}
