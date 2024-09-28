package com.fawry.customer.property;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/properties")
public class PropertyController {

    private final Environment environment;

    @Value("${app.developer}")
    private String developerName;
    @Value("${external.name}")
    public String externalConfig;

    @GetMapping("/dev-name")
    public String getDeveloperName() {
        return developerName;
    }

    @GetMapping("/{key}")
    public String getPropByKey(@PathVariable String key) {
        return environment.getProperty(key, "Property not found");
    }

    @GetMapping("/external")
    public String getExternalConfig() {
        return externalConfig;
    }

}
