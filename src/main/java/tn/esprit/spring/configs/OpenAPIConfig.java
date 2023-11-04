package tn.esprit.spring.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());

    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("Case Study - SKI STATION")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("khadija.agoun@esprit.tn")
                .url("www.linkedin.com/in/khadija-agoun-52080a227");
        return contact;
    }





}
