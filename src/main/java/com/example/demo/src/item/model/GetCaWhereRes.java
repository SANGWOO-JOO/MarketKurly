package com.example.demo.src.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor

public class GetCaWhereRes {

    private int categoryId;
    private String category;
    private String sub_category;

    private int itemId;
    private String name;
    private int price;

    private String discount_rate;
    private int member_discount_price;
    private Timestamp created_at;

    private String items_img_url;
    private int coupon;
    private int present;
}
