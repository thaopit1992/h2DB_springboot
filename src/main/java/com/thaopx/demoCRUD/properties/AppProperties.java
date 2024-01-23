package com.thaopx.demoCRUD.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Các thuộc tính ở class này phải giống với file application.properties
 * **/

@Data
@Component //Đánh dấu class này là một Spring bean, cho phép Spring quản lý nó
@ConfigurationProperties(prefix = "app")  // Đánh dấu class bên dưới nó là một properties class. Các thuộc tính trong class này sẽ tự động nạp giá trị từ cấu hình ứng dụng
public class AppProperties {
    private String name;
    private String version;
    private Security security;

    @Data
    public static class Security{
        private String username;
        private String pass;
        private List<String> role;
        private boolean enable;

        private Map<String, String> permission;

    }
}
