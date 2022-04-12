package com.example.kaiburr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableSwagger2
public class KaiburrApplication {

    public static void main(String[] args) {
        SpringApplication.run(KaiburrApplication.class, args);
    }

@Bean
    public Docket SwaggerConfiguration(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                .build()
                .apiInfo(Details());
}
private ApiInfo Details(){
        return new ApiInfo(
                "Kaiburr Server API",
                "API for Server resources",
                "1.0",
                "Free to use",
                new springfox.documentation.service.Contact("Santha Kumar Reddy","https://github.com/shanureddy4","shanureddy78@gmail.com"),
                "API License",
                "https://github.com/shanureddy4",
                Collections.emptyList());

}
}

