package io.github.wesleyosantos91.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.HashSet;
import java.util.Set;

import static java.util.Collections.singletonList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact DEFAULT_CONTACT = new Contact(
            "Wesley Oliveira Santos",
            "http://wesleyosantos.me/",
            "wesleyosantos91@gmail.com" );

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
            .title("POC - CRUD Springboot Generics Java")
            .description("Using Generics Java to CRUD Sprinboot")
            .version("0.0.1")
            .termsOfServiceUrl("http://www.termsofservice.url")
            .contact(DEFAULT_CONTACT)
            .license("License")
            .licenseUrl("http://www.license.url")
            .build();

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
            singletonList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(ApiIgnore.class)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/persons/**"))
                .build()
                .pathMapping("/")
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
                .apiInfo(DEFAULT_API_INFO);
    }
}
