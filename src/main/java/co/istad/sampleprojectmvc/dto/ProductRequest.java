package co.istad.sampleprojectmvc.dto;

import lombok.Builder;

@Builder
public record ProductRequest(String title,
                             String description,
                             float price,
                             String imageUrl
) {
}
