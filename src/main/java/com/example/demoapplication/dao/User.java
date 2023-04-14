package com.example.demoapplication.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private Integer age;
    private String gender;
    private String address;
}
