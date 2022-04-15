package com.example.demo.src.item.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor

public class GetHomeCategoryRes {
    private int homeSubjectId;
    private String homeSubject;
    private String vice_subject;
}
