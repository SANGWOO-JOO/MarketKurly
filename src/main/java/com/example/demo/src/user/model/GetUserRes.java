package com.example.demo.src.user.model;


import jdk.internal.joptsimple.internal.Strings;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.w3c.dom.Text;

import java.sql.*;   //Timestamp
import java.text.DecimalFormat;

@Getter
@Setter
@AllArgsConstructor
public class GetUserRes {
    private int idx;
    private Timestamp create_at;
    private Timestamp update_at;
    private String user_nick_name;
    private String img_url;
    private String manner_temp;
    private String retrade_rate;
    private String respone_rate;
    private int product_sale_num;

}
