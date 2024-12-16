package com.basic.basiccore.common.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 이렇게 설정정보에 이 어노테이션을 붙이면된다. 기존의 AppConfig 와 다르게 설정 정보 코드가 필요 없다.
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
