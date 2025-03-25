package org.bobpark.configure;

import java.time.Duration;

import lombok.RequiredArgsConstructor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Configuration
public class AppConfiguration {

    @Bean
    public RestClient restClient() {

        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();

        requestFactory.setConnectionRequestTimeout(Duration.ofSeconds(5));
        requestFactory.setReadTimeout(Duration.ofSeconds(5));

        return RestClient.builder()
            .requestFactory(requestFactory)
            .build();
    }
}
