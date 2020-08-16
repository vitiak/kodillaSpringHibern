package springhibern.shop.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RepositoryConfiguration {

    @Bean
    BallRepository repository() {
        return new InMemoryBallRepository();
    }
}
