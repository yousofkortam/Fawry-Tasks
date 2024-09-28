package com.fawry.customer;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
@Getter
@Setter
class AppInfo {
    private String version;
    private String gitHashCode;
    private String gitTag;
}
