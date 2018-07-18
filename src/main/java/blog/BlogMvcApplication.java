package blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Applies the default configuration settings for the Spring Boot application
@SpringBootApplication
@EnableJpaRepositories(basePackages = "blog")
@EntityScan(basePackages = "blog")
public class BlogMvcApplication {

    public static void main(String[] args) {
        //Starts the embedded Tomcat application server
        SpringApplication.run(BlogMvcApplication.class, args);
    }
}
