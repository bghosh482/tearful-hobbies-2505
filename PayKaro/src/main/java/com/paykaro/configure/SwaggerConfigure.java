package com.paykaro.configure;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigure {

	@Bean
	public Docket api() {

		return new Docket(DocumentationType.SWAGGER_2).apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();

	}

	public ApiInfo getInfo() {

		return new ApiInfo("PayKaro :Backend Application",
				"This is 5 members collaborative project develop by :-  Bubai Ghosh(fp04_460)"
						+ "  Roshni Gupta(fw18_1153) " + "  Abhishek Kumar(fw20_0653)  "
						+ "  Navneet Singh(fw19_0023)  " + "   Abhishek Kumar(fp03_155)  ",
				"2.0", "terms & condition apply",
				new Contact("Bubai Ghosh(Team-Lead)", "https:localhost:8888/paykaro", "bghosh482@gmail.com"), null,
				null, Collections.emptyList());
	}

}
