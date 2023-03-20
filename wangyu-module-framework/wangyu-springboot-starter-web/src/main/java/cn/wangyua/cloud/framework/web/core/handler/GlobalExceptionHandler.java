package cn.wangyua.cloud.framework.web.core.handler;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class GlobalExceptionHandler {
private final String applitaionName;
private final ApiErrorLogFrameworkService apiErrorLogFrameworkService;
}
