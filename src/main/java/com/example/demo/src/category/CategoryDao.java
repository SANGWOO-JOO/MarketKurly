package com.example.demo.src.category;

import com.example.demo.src.category.model.CategoryReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class CategoryDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public int createCategory(CategoryReq categoryReq) {
        String cretePaymentQuery = "insert into CATEGORY (category,image) VALUES (?,?)";
        Object[] createCategoryParam = new Object[]{categoryReq.getCategory(),categoryReq.getImage()};
        this.jdbcTemplate.update(cretePaymentQuery, createCategoryParam);


        String lastInsertIdQuery =  "select last_insert_id()"; //postUserReq.getId();

        return this.jdbcTemplate.queryForObject(lastInsertIdQuery,int.class); //Integ
    }




}
