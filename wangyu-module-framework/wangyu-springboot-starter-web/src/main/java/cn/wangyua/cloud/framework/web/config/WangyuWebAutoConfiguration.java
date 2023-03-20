package cn.wangyua.cloud.framework.web.config;

import cn.wangyua.cloud.framework.web.core.util.WebFrameworkUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;


@AutoConfiguration
@EnableConfigurationProperties({WebProperties.class, XssProperties.class})
public class WangyuWebAutoConfiguration implements WebMvcConfigurer {
    @Resource
    private WebProperties webProperties;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurePathMatch(configurer, webProperties.getAdminApi());
    }

    private void configurePathMatch(PathMatchConfigurer configurer, WebProperties.Api Api) {
        AntPathMatcher antPathMatcher = new AntPathMatcher(".");
        configurer.addPathPrefix(Api.getPrefix(), clazz -> clazz.isAnnotationPresent(RestController.class)
        && antPathMatcher.match(Api.getController(),clazz.getPackage().getName()));//仅仅匹配controller包
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler(ApiErrorLogFrameworkService ApiErrorLogFrameworkService){
        return new GlobalExceptionHandler(applicationName,ApiErrorLogFrameworkService);
    };

    @Bean
    public GlobalResponseBodyHandler globalResponseBodyHandler(){return new GlobalResponseBodyHandler};

    @Bean
    public WebFrameworkUtils  webFrameworkUtils(WebProperties webProperties){
        //由于WebFrameworkUtils需要用到webProperties属性，所以注册成一个BEAN
        return new WebFrameworkUtils(webProperties);
    }


}
