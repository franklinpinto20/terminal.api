package com.terminal.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * 
 * @author Franklin Pinto
 * @Project Gestion en Terminales
 * @Date 22/08/2024
 * @version 1.0.0
 */
//@Configuration
//@Profile({"dev", "test"})
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.terminal.api.controller"))
                .paths(PathSelectors.any()).build();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @SuppressWarnings({"deprecation"})
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Vial note management API")
                .description("Endpoint collection to manage vial note persistence layer")
                .termsOfServiceUrl("http://en.wikipedia.org/wiki/Terms_of_service").contact("Seguritech privada")
                .license("Apache License Version 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0").build();
    }
}
