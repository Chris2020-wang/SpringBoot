package springboot.front_endmvcbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MVC_basics_Application {

	public static void main(String[] args) {
		SpringApplication.run(MVC_basics_Application.class, args);
	}

//	@Bean
//	public String firstLayer() {
//		System.out.println("First");
//		return "hi";
//	}
//
//	@Bean
//	public String secondLayer(String firstLayer) {
//		System.out.println("Second" + firstLayer);
//		return "hi second";
//	}
//
//	@Bean
//	public String thirdLayer(String firstLayer) {
//		System.out.println("Third" + firstLayer);
//		return "hi third";
//	}
}
