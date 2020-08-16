package springhibern.shop.service;

import springhibern.shop.repository.BallRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BallServiceConfiguration {

    @Bean
    BallService ballService(BallRepository repository) {
        return new BallServiceImpl(repository);
    }

}
