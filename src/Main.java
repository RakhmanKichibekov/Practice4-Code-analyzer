import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class Main {
    @Bean
    public CommandLineRunner initDB(StudentsRepository repo) {
        return args -> {
            Faker faker = new Faker();
            for (int i = 1; i <= 100; i++) {
                repo.save(new Students(i, faker.name().firstName(), faker.internet().password(), UUID.randomUUID().toString()));
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}