package org.bobpark.domain.cafeteria.service;

import org.bobpark.domain.cafeteria.requester.CafeteriaResult;
import org.bobpark.domain.cafeteria.requester.GetCafeteriaRequest;

public interface CafeteriaService {

    CafeteriaResult getCafeteriaMenus(GetCafeteriaRequest getRequest);

}
