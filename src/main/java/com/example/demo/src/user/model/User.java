package com.example.demo.src.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int IDX;
    private String userNickName;
    private String imgUrl;
    private String mannerTemp;
    private String password;
}
