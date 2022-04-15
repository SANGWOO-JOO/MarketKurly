package com.example.demo.src.notice;

import com.example.demo.src.notice.model.NoticeReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class NoticeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public int createNotice(NoticeReq noticeReq) {
        String createNoticeQuery = "insert into Notice (description,time) VALUES (?,?)";
        Object[] createNoticeParam = new Object[]{noticeReq.getDescription(),noticeReq.getTime()};
        this.jdbcTemplate.update(createNoticeQuery, createNoticeParam);


        String lastInsertIdQuery =  "select last_insert_id()"; //postUserReq.getId();

        return this.jdbcTemplate.queryForObject(lastInsertIdQuery,int.class); //Integ
    }




}
