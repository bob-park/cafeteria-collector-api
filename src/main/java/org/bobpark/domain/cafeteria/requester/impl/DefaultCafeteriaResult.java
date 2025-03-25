package org.bobpark.domain.cafeteria.requester.impl;

import java.util.List;

import lombok.Builder;

import org.bobpark.domain.cafeteria.requester.CafeteriaItem;
import org.bobpark.domain.cafeteria.requester.CafeteriaResult;

@Builder
public record DefaultCafeteriaResult(List<? extends CafeteriaItem> items)
    implements CafeteriaResult {
}
