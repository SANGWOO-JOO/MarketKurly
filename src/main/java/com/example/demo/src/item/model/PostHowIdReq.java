package com.example.demo.src.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostHowIdReq {
    
    private int idx;
    private String user_nick_name;
    private String img_url;
    private String manner_temp;
    private String retrade_rate;
    private String respone_rate;
    private int product_sale_num;
    private String password;
}
