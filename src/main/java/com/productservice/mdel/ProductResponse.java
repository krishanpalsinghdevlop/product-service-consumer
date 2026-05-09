package com.productservice.mdel;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private String productId;
    @JsonDeserialize(using = DateDeserializerHelper.class)
    private LocalDateTime onlineFrom;
    @JsonDeserialize(using = DateDeserializerHelper.class)
    private LocalDateTime onlineTo;
    @JsonDeserialize(using = DateDeserializerHelper.class)
    private LocalDateTime updatedOn;
    @JsonDeserialize(using = DateDeserializerHelper.class)
    private LocalDateTime createdOn;
    private String name;
    private String category;
    private String color;
}
