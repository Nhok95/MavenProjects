package com.nhoksoft.carinsurance.configuration;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2 // enable SpringFox support for Swagger 2
public class SwaggerConfiguration {

	public Docket apiDocket() {

		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors
				.basePackage("com.grupoa.carinsurance.controllers"))
				.paths(PathSelectors.any()).build();
	}
}
