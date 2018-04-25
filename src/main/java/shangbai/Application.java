package shangbai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("shangbai.com.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication sapp = new SpringApplication(Application.class);
		sapp.run(args);
	}
	
	
}
