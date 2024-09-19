package dio.web.api.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.annotations.RouterOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Title - Rest API")
                        .description("API exemplo de uso de Springboot REST API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Seu nome")
                                .url("http://www.seusite.com.br")
                                .email("voce@seusite.com.br"))
                        .license(new License().name("Licença - Sua Empresa").url("http://www.seusite.com.br")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação Externa")
                        .url("http://www.seusite.com.br/docs"));
    }
}
