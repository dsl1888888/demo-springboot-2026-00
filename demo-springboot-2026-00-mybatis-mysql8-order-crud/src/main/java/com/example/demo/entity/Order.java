
package com.example.demo.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Order {
    private Long id;
    private String orderNo;
    private String productName;
    private Integer quantity;
    private Double price;
    private LocalDateTime createTime;
}
