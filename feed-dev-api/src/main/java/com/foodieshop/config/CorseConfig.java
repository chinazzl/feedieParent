package com.foodieshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: zhang zhao lin
 * @Description:
 * @Date:Create：in 2021/3/4 10:20
 * @Modified By：
 * <p>
 * 跨域 配置类
 * Access to XMLHttpRequest at 'http://localhost:8088/passport/regist' from origin
 * 'http://localhost:9000' has been blocked by CORS policy: Response to preflight
 * request doesn't pass access control check: No 'Access-Control-Allow-Origin' header
 * is present on the requested resource
 */
@Configuration
public class CorseConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", getCorseConfiguration());
        return new CorsFilter(source);
    }

    private CorsConfiguration getCorseConfiguration() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任何域名访问
        corsConfiguration.addAllowedOrigin("*");
        //允许任何header访问
        corsConfiguration.addAllowedHeader("*");
        //允许任何方法访问
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

}
