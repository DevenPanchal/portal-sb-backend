package com.neha.jobportal.jobportalbackend.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Bean
    public Docket produceApi(){
    return new Docket(DocumentationType.SWAGGER_2)
    .apiInfo(apiInfo())
    .select()
    .apis(RequestHandlerSelectors.basePackage("com.neha.jobportal.jobportalbackend.controllers"))
    .build();
}
// Describe your apis
private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
    .title("Job Portal Rest APIs")
    .description("This page lists all the rest apis exposed by the Job Portal Backend.")
    .version("1.0-SNAPSHOT")
    .build();
}

}

