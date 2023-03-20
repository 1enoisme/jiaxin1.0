package cn.wangyua.cloud.framework.web.core.util;

import cn.wangyua.cloud.framework.web.config.WebProperties;

/**
 * 专属于 web 包的工具类
 *
 * @author 芋道源码
 */
public class WebFrameworkUtils {

    private static final String REQUEST_ATTRIBUTE_LOGIN_USER_ID ="login_user_id";
    private static final String REQUEST_ATTRIBUTE_LOGIN_USER_TYPE ="login_user_type";

    private static final String REQUEST_ATTRIBUTE_COMMON_RESULT ="common_result";

    private static final String HEADER_TENANT_ID ="tenant-id";

    private static WebProperties properties;

    public WebFrameworkUtils(WebProperties webProperties) { WebFrameworkUtils.properties = webProperties;
    }
}
