package org.bobpark.configure.cafeteria;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import org.bobpark.configure.cafeteria.properties.CafeteriaProperties;
import org.bobpark.domain.cafeteria.requester.DelegatingCafeteriaRequester;
import org.bobpark.domain.cafeteria.requester.kakao.KakaoCafeteriaRequester;

@RequiredArgsConstructor
@Configuration
@EnableConfigurationProperties(CafeteriaProperties.class)
public class CafeteriaConfiguration {

    @Bean
    public DelegatingCafeteriaRequester cafeteriaRequester(RestClient restClient){
        DelegatingCafeteriaRequester requester = new DelegatingCafeteriaRequester();

        requester.add(new KakaoCafeteriaRequester(restClient));

        return requester;
    }
}
