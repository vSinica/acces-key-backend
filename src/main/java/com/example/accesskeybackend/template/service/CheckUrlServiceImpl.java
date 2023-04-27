package com.example.accesskeybackend.template.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.net.*;
import java.util.Arrays;

@Service
@AllArgsConstructor
@Log4j2
public class CheckUrlServiceImpl implements CheckUrlService {

    @Override
    public Boolean checkUrlHasIpV6(String url)  {

        URL uri;
        try {
            if(url.contains("https://") || url.contains("http://")){
                uri = new URL(url);
            } else {
                uri = new URL("http://"+url);
            }
        } catch (MalformedURLException  e) {
            throw new RuntimeException(e);
        }
        String host = uri.getHost() != null ? uri.getHost() : url;
        try {
            return Arrays.stream(InetAddress.getAllByName(host))
                    .anyMatch(a -> a instanceof Inet6Address);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}