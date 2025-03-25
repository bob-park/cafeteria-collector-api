package org.bobpark.configure.cafeteria.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.bobpark.configure.cafeteria.type.Cafeteria;

@ConfigurationProperties("cafeteria")
public record CafeteriaProperties(List<Cafeteria> list) {
}
