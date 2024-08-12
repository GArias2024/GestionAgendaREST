package com.contact.manag.agenda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Bandwidth;

import java.time.Duration;

@Configuration
public class RateLimiterConfig {

    @Bean
    public Bucket rateLimiter() {
        Bandwidth limit = Bandwidth.simple(10, Duration.ofMinutes(1));
        return Bucket4j.builder()
                .addLimit(limit)
                .build();
    }
}
