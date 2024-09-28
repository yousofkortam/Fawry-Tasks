package com.fawry.customer.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sms")
public class SmsController {

    private final SmsProperties smsProperties;

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message) {
        return "Message '" + message + "' sent successfully with property sms.appId=" + smsProperties.getAppId();
    }

}
