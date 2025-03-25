package org.bobpark.domain.cafeteria.requester.impl;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;

import org.bobpark.domain.cafeteria.requester.CafeteriaItem;

@Builder
public record DefaultCafeteriaItem(String id,
                                   List<String> menus,
                                   List<String> imageUrls,
                                   LocalDateTime createdDate)
    implements CafeteriaItem {
}
