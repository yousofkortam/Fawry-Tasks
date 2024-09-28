package com.fawry.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class CustomerApplication {

    private final AppInfo appInfo;

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @GetMapping("/app-info")
    public String getAppInfo() {
        return "Build number: " + this.appInfo.getVersion() +
                "\nGIT hash code: " + this.appInfo.getGitHashCode() +
                "\nGit Tag: " + this.appInfo.getGitTag();
    }

}
