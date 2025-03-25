package org.bobpark.domain.cafeteria.model.v1;

import org.bobpark.configure.cafeteria.type.CafeteriaType;
import org.bobpark.domain.cafeteria.requester.GetCafeteriaRequest;

public record GetCafeteriaV1Request(String id,
                                    CafeteriaType type)
    implements GetCafeteriaRequest {
}
