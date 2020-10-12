package it.marcinmatynia.bookingApplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket SwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("bookingApplication")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/v1/.*"))
                .build()
                .globalResponseMessage(RequestMethod.GET,
                        Collections.singletonList(new ResponseMessageBuilder()
                                .code(500)
                                .message("500 message")
                                .responseModel(new ModelRef("Error"))
                                .build()));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Booking Application")
                .description("Swagger module for Booking Application")
                .contact(new Contact("Marcin Matynia",
                        "https://www.linkedin.com/in/marcinmatynia/",
                        "kontakt@marcinmatynia.it"))
                .version("1.0.1")
                .build();
    }
}