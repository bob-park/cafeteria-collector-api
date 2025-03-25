package org.bobpark.domain.cafeteria.controller.v1;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.bobpark.domain.cafeteria.model.v1.GetCafeteriaV1Request;
import org.bobpark.domain.cafeteria.requester.CafeteriaResult;
import org.bobpark.domain.cafeteria.service.v1.CafeteriaV1Service;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/cafeteria")
public class CafeteriaV1Controller {

    private final CafeteriaV1Service cafeteriaService;

    @GetMapping(path = "")
    public CafeteriaResult getCafeteriaMenus(GetCafeteriaV1Request getRequest) {
        return cafeteriaService.getCafeteriaMenus(getRequest);
    }

}
