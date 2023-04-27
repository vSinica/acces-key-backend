package com.example.accesskeybackend.template.service;

import java.net.UnknownHostException;

public interface CheckUrlService {

    Boolean checkUrlHasIpV6(String url) throws UnknownHostException;
}
