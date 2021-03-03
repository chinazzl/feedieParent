package com.foodieshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/3 18:10
 * @Modified By：
 */
@Configuration
@EnableSwagger2
public class Swag2Conf {

    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfos())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.foodieshop.controller")) //扫描controller包
                .paths(PathSelectors.any()) // 所有的路径
                .build();
    }

    private ApiInfo apiInfos() {
        return new ApiInfoBuilder()
                .title("商城demo")
                .description("商城demo接口文档")
                .version("1.0.1")
                .contact(new Contact("july","feedby.com","a@immoc.com"))
                .build();
    }
}
