package com.example.demo.src.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor


public class GetCategoryRes {


    private String category;
    private String sub_category;
    private int itemId;
    private String name;


}
