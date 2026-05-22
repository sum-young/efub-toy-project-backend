package efub.toyproejct.twitter_toy_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TwitterToyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(TwitterToyProjectApplication.class, args);
    }

}
