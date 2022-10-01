package com.example.js;

import lombok.Data;

@Data
public class SampleDto {

    private String name;

    private String age;

    private String gender;

    public SampleDto() {
    }

    public SampleDto(String name, String age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
