package com.example.accesskeybackend.template.controller;

import com.example.accesskeybackend.template.service.CheckUrlService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/web")
@AllArgsConstructor
public class CheckUrlController {

    private final CheckUrlService checkUrlService;

    @GetMapping("/checkIpv6Support")
    public Boolean generateTemplates(
            @RequestParam final String siteUrl
    ) throws UnknownHostException {
        return checkUrlService.checkUrlHasIpV6(siteUrl);
    }
}
