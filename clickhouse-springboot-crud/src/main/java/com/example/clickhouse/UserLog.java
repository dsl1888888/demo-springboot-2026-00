package com.example.clickhouse;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLog {
    private Long id;
    private String username;
    private Integer age;
    private LocalDateTime createdAt;
}
