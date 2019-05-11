package com.cdg.base.config;

import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Locale;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket consoleApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("console")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.cdg.base.interfaces.web"))
            .paths(Predicates.not(PathSelectors.ant("/**/admin/**")))
            .build()
            .useDefaultResponseMessages(false)
            .ignoredParameterTypes(Locale.class)
            .genericModelSubstitutes(Mono.class)
            .genericModelSubstitutes(Flux.class);
    }

    @Bean
    public Docket adminApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .groupName("admin")
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.cdg.base.interfaces.web"))
            .paths(Predicates.or(Lists.newArrayList(PathSelectors.ant("/**/admin/**"))))
            .build()
            .useDefaultResponseMessages(false)
            .ignoredParameterTypes(Locale.class)
            .genericModelSubstitutes(Mono.class)
            .genericModelSubstitutes(Flux.class);
    }

}
