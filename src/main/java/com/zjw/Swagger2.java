package com.zjw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

/**
 * Created by zjw on 2018/9/17  下午5:19
 */
//通过@Configuration注解，让Spring来加载该类配置。再通过@EnableSwagger2注解来启用Swagger2
@Configuration
@EnableSwagger2
public class Swagger2 {

    //从yml配置文件里获取是否启用swagger api
    @Value("${swagger.show}")
    private boolean swaggerShow;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerShow)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zjw.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact=new Contact("zjw","https://github.com/1176967052/personal-site","1176967052@qq.com");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful API")
                .description("spring boot Restful api")
                .termsOfServiceUrl("hello")
                .contact(contact)
                .version("1.0")
                .build();
    }


}
