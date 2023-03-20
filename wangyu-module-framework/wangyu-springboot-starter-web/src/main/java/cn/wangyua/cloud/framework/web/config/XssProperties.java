package cn.wangyua.cloud.framework.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

@Validated
@Data
@ConfigurationProperties(prefix = "wangyu.xss")
public class XssProperties {
    private  boolean enable =true;
    private List<String> excludeUrls = Collections.emptyList();
}
