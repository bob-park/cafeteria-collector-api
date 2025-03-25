package org.bobpark.domain.cafeteria.requester;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import com.malgn.common.exception.NotSupportException;

import org.bobpark.configure.cafeteria.type.CafeteriaType;

@Slf4j
public class DelegatingCafeteriaRequester {

    private final List<CafeteriaRequester> requesters = new ArrayList<>();

    public CafeteriaResult requester(GetCafeteriaRequest request, CafeteriaType type) {

        for (CafeteriaRequester requester : requesters) {
            if (!requester.isSupport(type)) {
                continue;
            }

            return requester.request(request);
        }

        throw new NotSupportException("No matching cafeteria requester...");
    }

    public void add(CafeteriaRequester requester) {
        requesters.add(requester);

        log.debug("added cafeteria request. ({})", requester.getClass().getSimpleName());
    }

}
