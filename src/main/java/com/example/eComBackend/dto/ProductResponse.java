package com.example.eComBackend.dto;

import java.util.List;

public record ProductResponse(Long id, String name, String desc, Double price, Long stock,
                              Long storeId, Long categoryId, Double rating, Long sellCount,
                              List<String> images) {
}
