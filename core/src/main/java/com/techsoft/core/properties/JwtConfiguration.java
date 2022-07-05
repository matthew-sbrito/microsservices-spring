package com.techsoft.core.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author Matheus Brito
 */
@Configuration
@ConfigurationProperties(prefix = "jwt.config")
@Getter
@Setter
@ToString
public class JwtConfiguration {
    private String loginURL = "/login/**";

    @NestedConfigurationProperty
    private Header header = new Header();

    private int expiration = 60 * 60; // ONE HOUR

    private String privateKey = "d4d984asd98a4s9d49as49d4ad4a9sd84as94wjkneaknj";
    private String type = "encrypted";

    @Getter
    @Setter
    public static class Header {
        private String name = "Authorization";
        private String prefix = "Bearer";
    }
}
