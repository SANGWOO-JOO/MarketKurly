package com.example.demo.src.item.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor

public class GetHomeLogicRes {
    private int homeSubjectId;
    private int itemId;
    private String name;
    private int price;

    private String discount_rate;
    private int member_discount_price;
    private Timestamp created_at;

    private String items_img_url;
    private int coupon;
    private int present;
    private Timestamp newyear_count;
}
