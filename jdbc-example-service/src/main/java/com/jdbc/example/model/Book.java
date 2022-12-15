package com.jdbc.example.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;
    private String name;
    private BigDecimal price;
}
