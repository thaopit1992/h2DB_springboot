package com.thaopx.demoCRUD.service;

import com.thaopx.demoCRUD.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppPropertiesTestService {
    @Autowired
    AppProperties appProperties;

    @Autowired
    public AppPropertiesTestService(AppProperties applicationProperties) {
        this.appProperties = applicationProperties;
    }

    public void getAppInfo() {
        //#Top leevet app properties
        System.out.println("app name: " + appProperties.getName());
        System.out.println("app version: " + appProperties.getVersion());
        //#Nested Properties
        System.out.println("user name: " + appProperties.getSecurity().getUsername());
        System.out.println("pass: " + appProperties.getSecurity().getPass());
        System.out.println("role: " + appProperties.getSecurity().getRole());
        System.out.println("enable:" + appProperties.getSecurity().isEnable());
        //#Map Properties
        System.out.println("String Map:" + appProperties.getSecurity().getPermission());

    }


}
