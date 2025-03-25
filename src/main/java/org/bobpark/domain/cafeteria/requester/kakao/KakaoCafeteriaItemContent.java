package org.bobpark.domain.cafeteria.requester.kakao;

import com.fasterxml.jackson.annotation.JsonAlias;

public record KakaoCafeteriaItemContent(@JsonAlias("t") String type,
                                        @JsonAlias("v") String value) {
}
