package org.bobpark.domain.cafeteria.requester;

import java.time.LocalDateTime;
import java.util.List;

public interface CafeteriaItem {

    String id();

    List<String> menus();

    List<String> imageUrls();

    LocalDateTime createdDate();

}
