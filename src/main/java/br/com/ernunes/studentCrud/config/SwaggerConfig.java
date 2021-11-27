package br.com.ernunes.studentCrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
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
    public Docket api(){
        // a docket is an instance of docs
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.ernunes.studentCrud"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Documentation for Spring Crud",
                "A smart documentation from Swagger", "V1",
                "https://www.facebook.com/profile.php?id=100016861326821",
                new Contact("Everton Rogerio Nunes", "https://www.facebook.com/profile.php?id=100016861326821",
                        "everton.nunes01o@fatec.sp.gov.br"),
                "License", "http://www.google.com",
                Collections.emptyList());
    }

}
