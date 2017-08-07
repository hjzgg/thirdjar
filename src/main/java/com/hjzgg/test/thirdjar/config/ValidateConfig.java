package com.hjzgg.test.thirdjar.config;

import com.hjzgg.test.thirdjar.common.util.ValidateUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties("validate")
public class ValidateConfig {

    private Boolean ifCheckFlag = false;

    public void setIfCheckFlag(Boolean ifCheckFlag) {this.ifCheckFlag = ifCheckFlag;}

    @Bean
    public ValidateUtils validateUtils() {
        return new ValidateUtils(ifCheckFlag);
    }

}
