package com.bulletinBoard.siwony.config

import org.springframework.http.HttpMethod.*
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

class WebMvcConfig : WebMvcConfigurer{

    /**
     * CORS 설정
     * GET, POST, PUT, DELETE, HEAD, OPTIONS 허용
     * @author siwony
     */
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8080", "https://localhost:8080")
            .allowedMethods(
                GET.name,
                POST.name,
                PUT.name,
                DELETE.name,
                HEAD.name,
                OPTIONS.name
            )
            .maxAge(3600)
    }
}