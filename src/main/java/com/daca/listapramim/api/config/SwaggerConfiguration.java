package com.daca.listapramim.api.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import antlr.collections.List;
import io.swagger.annotations.AuthorizationScope;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	
	
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfoBuilder()
			.title("OPI Manager API")
			.description("Manager to OPI")
			.version("0.0.1")
			.build();
	
	
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(
			Arrays.asList("application/json"));

	private static final ApiKey apiKey() {
		return new ApiKey("apiKey", "Authorization", "header");
	}

}
