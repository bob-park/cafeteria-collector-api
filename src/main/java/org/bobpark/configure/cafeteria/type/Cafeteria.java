package org.bobpark.configure.cafeteria.type;

import lombok.Builder;

@Builder
public record Cafeteria(String id,
                        CafeteriaType type,
                        String description) {
}
