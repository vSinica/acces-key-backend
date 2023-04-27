package com.example.accesskeybackend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CheckUrlTest
{

    @Autowired
    RestTemplate restTemplate;

    private final String NOT_IPV6_URL = "www.google.com";

    @Test
    public void CheckUrl() throws MalformedURLException {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("test","test");
        HttpEntity request = new HttpEntity(headers);

       ResponseEntity<Boolean> response = restTemplate.exchange("http://localhost:8080/api/web/checkIpv6Support?siteUrl=" + NOT_IPV6_URL,
                HttpMethod.GET, request ,Boolean.class);

       Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
       Assertions.assertFalse(response.getBody());
    }

}
