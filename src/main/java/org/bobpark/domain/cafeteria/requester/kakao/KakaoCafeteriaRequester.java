package org.bobpark.domain.cafeteria.requester.kakao;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestClient;

import org.bobpark.configure.cafeteria.type.CafeteriaType;
import org.bobpark.domain.cafeteria.requester.CafeteriaItem;
import org.bobpark.domain.cafeteria.requester.CafeteriaRequester;
import org.bobpark.domain.cafeteria.requester.CafeteriaResult;
import org.bobpark.domain.cafeteria.requester.GetCafeteriaRequest;
import org.bobpark.domain.cafeteria.requester.impl.DefaultCafeteriaItem;
import org.bobpark.domain.cafeteria.requester.impl.DefaultCafeteriaResult;

@Slf4j
@RequiredArgsConstructor
public class KakaoCafeteriaRequester implements CafeteriaRequester {

    private static final CafeteriaType DEFAULT_TYPE = CafeteriaType.KAKAO;

    private static final String DEFAULT_REQUEST_URL = "https://pf.kakao.com/rocket-web/web/profiles/{id}/posts?includePinnedPost=true";

    private final RestClient restClient;

    @Override
    public CafeteriaResult request(GetCafeteriaRequest getRequest) {

        KakaoCafeteriaResponse response =
            restClient.
                get()
                .uri(DEFAULT_REQUEST_URL, getRequest.id())
                .retrieve()
                .body(new ParameterizedTypeReference<KakaoCafeteriaResponse>() {
                });

        List<? extends CafeteriaItem> items =
            response.items().stream()
                .map(item ->
                    DefaultCafeteriaItem.builder()
                        .id(String.valueOf(item.id()))
                        .menus(
                            item.contents() != null ? extractMenus(
                                item.contents().stream()
                                    .map(KakaoCafeteriaItemContent::value)
                                    .toList()) : null)
                        .imageUrls(item.media() != null ?
                            extractImageMenus(
                                item.media().stream()
                                    .map(KakaoCafeteriaItemMedia::url)
                                    .toList()) : null)
                        .createdDate(
                            LocalDateTime.ofInstant(
                                Instant.ofEpochMilli(item.createdDate()),
                                TimeZone.getDefault().toZoneId()))
                        .build())
                .toList();

        return DefaultCafeteriaResult.builder()
            .items(items)
            .build();
    }

    @Override
    public boolean isSupport(CafeteriaType type) {
        return type == DEFAULT_TYPE;
    }

    private List<String> extractMenus(List<String> contents) {

        List<String> result = new ArrayList<>();

        for (String content : contents) {
            String[] tokens = content.split("\\s");

            int index = 0;

            for (String token : tokens) {
                if (index != 0 && index != tokens.length - 1) {
                    result.add(token.trim());
                }

                index++;
            }
        }

        return result;
    }

    private List<String> extractImageMenus(List<String> urls) {
        List<String> result = new ArrayList<>();

        for (String url : urls) {
            result.add(url.trim());
        }

        return result;
    }
}
