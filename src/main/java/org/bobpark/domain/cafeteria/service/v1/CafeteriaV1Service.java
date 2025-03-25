package org.bobpark.domain.cafeteria.service.v1;

import static com.google.common.base.Preconditions.*;
import static org.apache.commons.lang3.ObjectUtils.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import org.apache.commons.lang3.StringUtils;

import org.bobpark.domain.cafeteria.model.v1.GetCafeteriaV1Request;
import org.bobpark.domain.cafeteria.requester.CafeteriaResult;
import org.bobpark.domain.cafeteria.requester.DelegatingCafeteriaRequester;
import org.bobpark.domain.cafeteria.requester.GetCafeteriaRequest;
import org.bobpark.domain.cafeteria.service.CafeteriaService;

@Slf4j
@RequiredArgsConstructor
@Service
public class CafeteriaV1Service implements CafeteriaService {

    private final DelegatingCafeteriaRequester cafeteriaRequester;

    @Override
    public CafeteriaResult getCafeteriaMenus(GetCafeteriaRequest getRequest) {

        GetCafeteriaV1Request getV1Request = (GetCafeteriaV1Request)getRequest;

        checkArgument(StringUtils.isNotBlank(getV1Request.id()), "id must be provided.");
        checkArgument(isNotEmpty(getV1Request.type()), "type must be provided.");

        return cafeteriaRequester.requester(getV1Request, getV1Request.type());
    }
}
