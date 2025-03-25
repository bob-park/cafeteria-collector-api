package org.bobpark.domain.cafeteria.requester.kakao;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record KakaoCafeteriaItem(Long id,
                                 List<KakaoCafeteriaItemContent> contents,
                                 List<KakaoCafeteriaItemMedia> media,
                                 @JsonAlias("created_at") Long createdDate) {
}
