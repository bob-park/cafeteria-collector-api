package org.bobpark.domain.cafeteria.requester;

import org.bobpark.configure.cafeteria.type.CafeteriaType;

public interface CafeteriaRequester {

    CafeteriaResult request(GetCafeteriaRequest getRequest);

    default boolean isSupport(CafeteriaType type) {
        return false;
    }

}
