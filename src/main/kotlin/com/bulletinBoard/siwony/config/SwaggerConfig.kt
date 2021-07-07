package com.bulletinBoard.siwony.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
class SwaggerConfig {

    private fun apiInfo(): ApiInfo? {
        return ApiInfoBuilder()
            .title("게시판 API")
            .description("오늘 코틀린이 떙긴다.")
            .build()
    }

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2)
            .groupName("bulletinBoard")
            .apiInfo(apiInfo())
            .select()
            .apis(
                RequestHandlerSelectors
                    .basePackage("com.bulletinBoard.siwony")
            )
            .paths(PathSelectors.ant("/v1/**"))
            .build()
    }
}