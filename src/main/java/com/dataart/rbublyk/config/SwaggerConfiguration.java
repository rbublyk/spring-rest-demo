package com.dataart.rbublyk.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.models.dto.builder.ApiInfoBuilder;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

@Configuration
@EnableSwagger
public class SwaggerConfiguration {

    @Inject
    private SpringSwaggerConfig springSwaggerConfig;

    @Bean
    public SwaggerSpringMvcPlugin configureSwagger(){
        SwaggerSpringMvcPlugin swaggerSpringMvcPlugin = new
                SwaggerSpringMvcPlugin(this.springSwaggerConfig);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Rituala API")
                .description("Rituala operations")
                .build();
        swaggerSpringMvcPlugin.apiInfo(apiInfo)
                .apiVersion("1.0.0");
        return swaggerSpringMvcPlugin;
    }
}
