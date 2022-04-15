package com.example.demo.src.item.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetItemMoreRes {

    private int itemId;
    private String items_img_url;
    private String name;
    private String Product_description;
    private int price;
    private String discount_rate;
    private int member_discount_price;
    private int coupon;
    private int couponId;
    private int present;
    private int quantity;
    private String more_informaion_url;

    private String sales_unit;
    private String weight_capacity;
    private String shipping_category;
    private String origin;
    private String packaging_type;
    private String shelf_life;
    private String notification;
    private String item_details_img_url;

}
