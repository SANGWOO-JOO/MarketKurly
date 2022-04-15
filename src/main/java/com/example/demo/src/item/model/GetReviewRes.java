package com.example.demo.src.item.model;

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
public class GetReviewRes {
    private String title;
    private String image;
    private String discription;
    private int score;

}
