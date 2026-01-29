package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@NoArgsConstructor  // 必须：用于 JSON 反序列化
//@AllArgsConstructor // 可选：方便创建对象
public class User {
    private Long id;
    private String name;
    private String email;

    // Standard getters and setters are required for JSON serialization
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
