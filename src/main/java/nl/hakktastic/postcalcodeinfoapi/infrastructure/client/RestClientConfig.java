package nl.hakktastic.postcalcodeinfoapi.infrastructure.client;

import nl.hakktastic.postcalcodeinfoapi.infrastructure.client.restcountries.RestCountriesService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.support.RestClientHttpServiceGroupConfigurer;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(value = RestCountriesService.class)
class RestClientConfig {

    @Bean
    RestClientHttpServiceGroupConfigurer groupConfigurer() {
        return groups -> {
            groups.forEachClient((group, builder) -> builder
                    .baseUrl("https://restcountries.com/")
                    .build()
            );
        };
    }
}