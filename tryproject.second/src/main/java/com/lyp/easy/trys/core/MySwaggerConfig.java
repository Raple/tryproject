package com.lyp.easy.trys.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by lyp on 2016/10/9.
 */
@Configuration
@EnableSwagger2
public class MySwaggerConfig {

    @Bean
    ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "易淘TRY API",
                "提供详细的后台所有Restful接口",
                "Version2",
                "http://boss.etao.cn",
                "lin.yanping@etao.cn",
                "易淘lyp",
                "http://www.etao.cn" );
        return apiInfo;
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }

}
