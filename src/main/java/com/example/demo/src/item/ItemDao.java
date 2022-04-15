package com.example.demo.src.item;


import com.example.demo.src.item.model.*;
import com.example.demo.src.user.model.PostHowReq;
import com.example.demo.src.user.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;


@Repository
public class ItemDao {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


// 41번 API

    public List<GetItemRes> getItems(){
        String getItemsQuery = "select I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, A.category AS category,SC.category AS sub_category,\n" +
                "I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY A LEFT JOIN SUB_CATEGORY SC on A.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id;";
        return this.jdbcTemplate.query(getItemsQuery,
                (rs,rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                )
        );
    }

//    49번 API

    public List<GetItemRes> getNew(){
        String getItemsQuery = "SELECT I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, C.category AS category,SC.category AS sub_category,\n" +
                "    I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY C LEFT JOIN SUB_CATEGORY SC on C.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "WHERE name IS NOT NULL\n" +
                "ORDER BY I.created_at DESC";
        return this.jdbcTemplate.query(getItemsQuery,
                (rs,rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                )
        );
    }
// 50번 API
    public List<GetItemRes> getBest(){
        String getItemsQuery = "SELECT I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, C.category AS category,SC.category AS sub_category,\n" +
                "    I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY C LEFT JOIN SUB_CATEGORY SC on C.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "WHERE I.name IS NOT NULL\n" +
                "ORDER BY I.sales_rate DESC;";
        return this.jdbcTemplate.query(getItemsQuery,
                (rs,rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                )
        );
    }

    // 51번 API
    public List<GetItemRes> getDiscount(){
        String getItemsQuery = "SELECT I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, C.category AS category,SC.category AS sub_category,\n" +
                "       I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY C LEFT JOIN SUB_CATEGORY SC on C.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "WHERE NOT I.discount_rate LIKE '0%%'\n" +
                "order by I.discount_rate desc;";
        return this.jdbcTemplate.query(getItemsQuery,
                (rs,rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                )
        );
    }

    public List<GetItemRes> getRp(){
        String getItemsQuery = "SELECT I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, C.category AS category,SC.category AS sub_category,\n" +
                "       I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY C LEFT JOIN SUB_CATEGORY SC on C.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "where I.name IS NOT NULL\n" +
                "order by I.member_discount_price;";
        return this.jdbcTemplate.query(getItemsQuery,
                (rs,rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                )
        );
    }
    public List<GetItemRes> getHp(){
        String getItemsQuery = "SELECT I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, C.category AS category,SC.category AS sub_category,\n" +
                "       I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY C LEFT JOIN SUB_CATEGORY SC on C.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "where I.name IS NOT NULL\n" +
                "order by I.member_discount_price desc;";
        return this.jdbcTemplate.query(getItemsQuery,
                (rs,rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                )
        );
    }




    //Query String
    // API 명세서 45번
    public List<GetCategoryRes> getCaa(){
        String getCategoryQuery = "select C.category AS category , SC.category AS sub_category , I.id  As itemId , I.name AS name\n" +
                "from CATEGORY C LEFT JOIN SUB_CATEGORY SC on C.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "WHERE I.id IS NOT NULL";
        return this.jdbcTemplate.query(getCategoryQuery,
                (rs,rowNum) -> new GetCategoryRes(
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("itemId"),
                        rs.getString("name")
                )
        );
    }
    //Query String
    // API 명세서 46번
    public List<GetCaAllReS> getCaall(){
        String getCateAllQuery = "select CA.id AS cateogryId,CA.category AS cateogryName, CA.image AS  \"imageULR\"\n" +
                "from CATEGORY CA;";
        return this.jdbcTemplate.query(getCateAllQuery,
                (rs,rowNum) -> new GetCaAllReS(
                        rs.getInt("cateogryId"),
                        rs.getString("cateogryName"),
                        rs.getString("imageULR")
                )
        );
    }
    //Query String
    // API 명세서 47번
    public List<GetCaWhereRes> getCawhere(){
        String getCateWhereQuery = "select CA.id                   AS categoryId,\n" +
                "       CA.category             AS category,\n" +
                "       SC.category             AS sub_category,\n" +
                "       I.id                    AS itemId,\n" +
                "       I.name                  AS name,\n" +
                "       I.price                 AS price,\n" +
                "       I.discount_rate         AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,\n" +
                "       I.created_at            AS created_at,\n" +
                "       I.items_img_url         AS items_img_url,\n" +
                "       I.coupon                AS coupon,\n" +
                "       I.present               AS present\n" +
                "FROM CATEGORY CA\n" +
                "         LEFT JOIN SUB_CATEGORY SC on CA.id = SC.category_id\n" +
                "         LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "ORDER BY CA.id, I.id;";
        return this.jdbcTemplate.query(getCateWhereQuery,
                (rs,rowNum) -> new GetCaWhereRes(
                        rs.getInt("categoryId"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present")


                )
        );
    }


// 2. 주제별 API 생성

    public List<GetHomeCategoryRes> getHc(){
        String getHomeCategoryQuery = "select H.id AS homeSubjectId, H.category AS homeSubject, H.vice_subject AS vice_subject\n" +
                "FROM HOMECATEGORY_ALL AS H";
        return this.jdbcTemplate.query(getHomeCategoryQuery,
                (rs,rowNum) -> new GetHomeCategoryRes(
                        rs.getInt("homeSubjectId"),
                        rs.getString("homeSubject"),
                        rs.getString("vice_subject")
                )
        );
    }




// HOW 전체 조회 API

    public List<GetHowRes> getAll(){
        String getHowsQuery = "select I.new_column AS homeSubjectId ,I.id AS itemID, I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,\n" +
                "                    I.coupon AS coupon, I.present AS present,I.newyear_count         AS newyear_count\n" +
                "FROM ITEMS I\n" +
                "ORDER BY I.new_column;";

        return this.jdbcTemplate.query(getHowsQuery,
                (rs,rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                )
        );
    }


    // Home_Category 하나식 조회 API
    // API 64번

    public List<GetHowRes> getHows(){
        String getHowsQuery = "SELECT HA.id AS homeSubjectId ,I.id AS itemId ,I.name AS name, I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,I.coupon AS coupon, I.present AS present,I.newyear_count AS newyear_count\n" +
                "FROM HOMECATEGORY_ALL HA LEFT JOIN HOW H on HA.id = H.homecate_id LEFT JOIN ITEMS I on H.id = I.new_product_order_id LEFT JOIN BASKETS B on I.id = B.item_id\n" +
                "WHERE B.count >=1";

        return this.jdbcTemplate.query(getHowsQuery,
                (rs,rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                )
                );
    }
    // Home_Category 하나식 조회 API
    // API 65번

        public List<GetHowRes> getNy(){
        String getHowsQuery = "SELECT HA.id AS homeSubjectId,I.id AS itemId ,I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,I.coupon AS coupon, I.present AS present,I.newyear_count AS newyear_count\n" +
                "FROM HOMECATEGORY_ALL HA LEFT JOIN NEWYEAR N on HA.id = N.homecate_id LEFT JOIN ITEMS I on N.id = I.newyear_id\n" +
                "WHERE TIMESTAMP (I.special_time) BETWEEN '2022-01-31' AND '2022-02-02'";

        return this.jdbcTemplate.query(getHowsQuery,
                (rs,rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                )
        );
    }
    // Home_Category 하나식 조회 API
    // API 66번

    public List<GetHowRes> getRg(){
        String getHowsQuery = "SELECT HA.id AS homeSubjectId,I.id AS itemId ,I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,I.coupon AS coupon, I.present AS present,I.newyear_count AS newyear_count\n" +
                "FROM HOMECATEGORY_ALL HA LEFT JOIN REGRET R on HA.id = R.homecate_id LEFT JOIN ITEMS I on R.id = I.regret_id\n" +
                "WHERE NOT I.discount_rate LIKE '0%%'\n" +
                "ORDER BY I.price , discount_rate ";

        return this.jdbcTemplate.query(getHowsQuery,
                (rs,rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                )
        );
    }

    // API 67번

    public List<GetHowRes> getDl(){
        String getHowsQuery = "SELECT HA.id AS homeSubjectId ,I.id AS itemId ,I.name AS name, I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,I.coupon AS coupon, I.present AS present,I.newyear_count AS newyear_count\n" +
                "FROM HOMECATEGORY_ALL HA LEFT JOIN DEADLINE D on HA.id = D.homecate_id  LEFT JOIN ITEMS I on D.id = I.deadline_id\n" +
                "WHERE timestamp(I.special_time )>= '2022-01-21 00:00:00' AND '2022-01-28 00:00:00' <= timestamp(I.special_time ) AND  NOT I.discount_rate LIKE '0%%'";

        return this.jdbcTemplate.query(getHowsQuery,
                (rs,rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                )
        );
    }

    // API 68번

    public List<GetHowRes> getRv(){
        String getHowsQuery = "SELECT HA.id AS homeSubjectId ,I.id AS itemId ,I.name AS name, I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,I.coupon AS coupon, I.present AS present,I.newyear_count AS newyear_count\n" +
                "FROM HOMECATEGORY_ALL HA LEFT JOIN REVIEW R on HA.id = R.homecate_id LEFT JOIN ITEMS I on R.id = I.review_id LEFT JOIN(SELECT COUNT(*)\n" +
                "     \"Co\" from REVIEWS\n" +
                "group by  item_id) B on I.id = B.Co\n" +
                "WHERE I.name IS NOT NULL AND Co IS NOT NULL\n" +
                "ORDER BY Co DESC";

        return this.jdbcTemplate.query(getHowsQuery,
                (rs,rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                )
        );
    }

    // API 70번

    public List<GetReviewRes> getRvs(){
        String getReviewQuery = "select R.title AS title , R.image AS image , R.description AS discription , R.score AS score\n" +
                "FROM ITEMS JOIN REVIEWS R on ITEMS.id = R.item_id;";

        return this.jdbcTemplate.query(getReviewQuery,
                (rs,rowNum) -> new GetReviewRes(
                        rs.getString("title"),
                        rs.getString("image"),
                        rs.getString("discription"),
                        rs.getInt("score")
                )
        );
    }
    // API 71번

    public List<GetReviewRes> getReviewSearch(String Rv){
        String getReviewQuery = "select R.title AS title , R.image AS image , R.description AS discription , R.score AS score\n" +
                "FROM ITEMS I LEFT JOIN REVIEWS R on I.id = R.item_id\n" +
                "WHERE I.id =?";
        String getReviewParams = Rv;
        return this.jdbcTemplate.query(getReviewQuery,
                (rs,rowNum) -> new GetReviewRes(
                        rs.getString("title"),
                        rs.getString("image"),
                        rs.getString("discription"),
                        rs.getInt("score")
                ),
                getReviewParams);
    }


    // 69번 API

    public List<GetSearchRes> getSearch(String Se){
        String getSearchQuery = "select I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       \n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, A.category AS category,SC.category AS sub_category,\n" +
                "       I.coupon AS coupon, I.present AS present\n" +
                "       FROM CATEGORY A LEFT JOIN SUB_CATEGORY SC on A.id = SC.category_id \n" +
                "           LEFT JOIN ITEMS I on SC.id = I.sub_id \n" +
                "where I.name = ?";

        String getSearchParams = Se;
        return this.jdbcTemplate.query(getSearchQuery,
                (rs,rowNum) -> new GetSearchRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),

                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                ),
                getSearchParams);
    }
//48번
    public List<GetCaWhereRes> getSensitive(String Sensitive){
        String getSearchQuery = "select CA.id                   AS categoryId,\n" +
                "       CA.category             AS category,\n" +
                "       SC.category             AS sub_category,\n" +
                "       I.id                    AS itemId,\n" +
                "       I.name                  AS name,\n" +
                "       I.price                 AS price,\n" +
                "       I.discount_rate         AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,\n" +
                "       I.created_at            AS created_at,\n" +
                "       I.items_img_url         AS items_img_url,\n" +
                "       I.coupon                AS coupon,\n" +
                "       I.present               AS present\n" +
                "FROM CATEGORY CA\n" +
                "         LEFT JOIN SUB_CATEGORY SC on CA.id = SC.category_id\n" +
                "         LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "WHERE SC.category = ?";

        String getSearchParams = Sensitive;
        return this.jdbcTemplate.query(getSearchQuery,
                (rs,rowNum) -> new GetCaWhereRes(
                        rs.getInt("categoryId"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                ),
                getSearchParams);
    }

    public List<GetHomeLogicRes> getTest(int Te){

             String getTest1Query = "SELECT I.new_column AS homesubjectId,I.id AS itemId ,I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                     "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                     "       I.items_img_url AS items_img_url,I.coupon AS coupon, I.present AS present,\n" +
                     "       I.newyear_count AS newyear_count\n" +
                     "FROM ITEMS AS I\n" +
                     "WHERE I.new_column = ?";
                int getTest1Params = Te;
                return this.jdbcTemplate.query(getTest1Query,
                        (rs,rowNum) -> new GetHomeLogicRes(

                                rs.getInt("homeSubjectId"),
                                rs.getInt("itemId"),
                                rs.getString("name"),
                                rs.getInt("price"),

                                rs.getString("discount_rate"),
                                rs.getInt("member_discount_price"),
                                rs.getTimestamp("created_at"),

                                rs.getString("items_img_url"),
                                rs.getInt("coupon"),
                                rs.getInt("present"),
                                rs.getTimestamp("newyear_count")
                        ),
                        getTest1Params);
    }




    public GetHowRes getHow(int HOW) { //UserProvider.java에서 item_id값을 받아옴.
        String getHowQuery = "select H.id AS homeSubjectId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url,\n" +
                "       I.coupon AS coupon, I.present AS present\n" +
                "FROM HOW H LEFT JOIN ITEMS I on H.id = I.new_product_order_id where B2.count >= 1 AND id = ?"; //쿼리문 실행 DB 내 items_id로 조회
        int getHowParams = HOW;
        return this.jdbcTemplate.queryForObject(getHowQuery,
                (rs, rowNum) -> new GetHowRes(
                        rs.getInt("homeSubjectId"),
                        rs.getInt("itemId"),

                        rs.getString("name"),
                        rs.getInt("price"),

                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),

                        rs.getString("items_img_url"),
                        rs.getInt("coupon"),
                        rs.getInt("present"),
                        rs.getTimestamp("newyear_count")
                ),
                getHowParams);
    }


    //상품 1개 조회
    public GetItemRes getItem(int id){ //UserProvider.java에서 item_id값을 받아옴.
        String getItemQuery = "select I.id AS itemId , I.name AS name ,I.price AS price , I.discount_rate AS discount_rate,\n" +
                "       I.member_discount_price AS member_discount_price,I.created_at AS created_at,\n" +
                "       I.items_img_url AS items_img_url, A.category AS category,SC.category AS sub_category,\n" +
                "I.coupon AS coupon, I.present AS present\n" +
                "FROM CATEGORY A LEFT JOIN SUB_CATEGORY SC on A.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id where I.id = ?"; //쿼리문 실행 DB 내 items_id로 조회
        int getItemParams = id;
        return this.jdbcTemplate.queryForObject(getItemQuery,
                (rs, rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                ),
                getItemParams);
    }

    /**
     * 상품설명 조회 API
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<GetItemMoreRes> getItemsmores(){
        String getItemsmoresQuery = "select A.id AS itemId, A.items_img_url AS items_img_url, A.name AS name, ID.Product_description AS Product_description\n" +
                "       ,A.price AS price, A.discount_rate AS discount_rate,A.member_discount_price AS member_discount_price, C.coupon_bool AS coupon\n" +
                "       ,C.couponid AS couponId, P.present_bool AS present, A.quantity AS quantity,ID.more_informaion_url AS more_informaion_url,\n" +
                "       ID.sales_unit AS sales_unit,ID.weight_capacity AS weight_capacity, ID.shipping_category AS shipping_category,\n" +
                "       ID.origin AS origin, ID.packaging_type AS packaging_type, ID.shelf_life AS shelf_life,ID.notification\n" +
                "                    AS notification,   ID.item_details_img_url AS item_details_img_url\n" +
                "FROM ITEMS A LEFT JOIN ITEM_DETAILS ID on A.id = ID.item_id LEFT JOIN COUPONS C on A.id = C.items_id LEFT JOIN PRESENTS P\n" +
                "                    on A.id = P.items_id";
                  //getUsersQuery -> getItemsQuery
        return this.jdbcTemplate.query(getItemsmoresQuery,
                (rs,rowNum) -> new GetItemMoreRes(
                        rs.getInt("itemId"),
                        rs.getString("items_img_url"),
                        rs.getString("name"),
                        rs.getString("Product_description"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getInt("coupon"),
                        rs.getInt("couponId"),
                        rs.getInt("present"),

                        rs.getInt("quantity"),
                        rs.getString("more_informaion_url"),

                        rs.getString("sales_unit"),
                        rs.getString("weight_capacity"),
                        rs.getString("shipping_category"),
                        rs.getString("origin"),
                        rs.getString("packaging_type"),
                        rs.getString("shelf_life"),
                        rs.getString("notification"),
                        rs.getString("item_details_img_url")


                        )
        );
    }


    //상품설명 1개 조회

    public GetItemMoreRes getItemMore(int IDX){ //UserProvider.java에서 item_id값을 받아옴.
        String getItemMoreQuery = "select A.id AS itemId, A.items_img_url AS items_img_url, A.name AS name, ID.Product_description AS Product_description\n" +
                "       ,A.price AS price, A.discount_rate AS discount_rate,A.member_discount_price AS member_discount_price, C.coupon_bool AS coupon\n" +
                "       ,C.couponid AS couponId, P.present_bool AS present, A.quantity AS quantity,ID.more_informaion_url AS more_informaion_url,\n" +
                "       ID.sales_unit AS sales_unit,ID.weight_capacity AS weight_capacity, ID.shipping_category AS shipping_category,\n" +
                "       ID.origin AS origin, ID.packaging_type AS packaging_type, ID.shelf_life AS shelf_life,ID.notification\n" +
                "                    AS notification,   ID.item_details_img_url AS item_details_img_url\n" +
                "FROM ITEMS A LEFT JOIN ITEM_DETAILS ID on A.id = ID.item_id LEFT JOIN COUPONS C on A.id = C.items_id LEFT JOIN PRESENTS P\n" +
                "                    on A.id = P.items_id WHERE A.id = ?"; //쿼리문 실행 DB 내 items_id로 조회
        int getItemMoreParams = IDX;
        return this.jdbcTemplate.queryForObject(getItemMoreQuery,
                (rs, rowNum) -> new GetItemMoreRes(
                        rs.getInt("itemId"),
                        rs.getString("items_img_url"),
                        rs.getString("name"),
                        rs.getString("Product_description"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getInt("coupon"),
                        rs.getInt("couponId"),
                        rs.getInt("present"),

                        rs.getInt("quantity"),
                        rs.getString("more_informaion_url"),

                        rs.getString("sales_unit"),
                        rs.getString("weight_capacity"),
                        rs.getString("shipping_category"),
                        rs.getString("origin"),
                        rs.getString("packaging_type"),
                        rs.getString("shelf_life"),
                        rs.getString("notification"),
                        rs.getString("item_details_img_url")

                ),
                getItemMoreParams);
    }

    /**
     * 상품설명 1개 조회 API
     */
    //42번
    public GetItemRes getItemone(int itemonea){ //UserProvider.java에서 item_id값을 받아옴.
        String getItemQuery = "select I.id                    AS itemId,\n" +
                "       I.name                  AS name,\n" +
                "       I.price                 AS price,\n" +
                "       I.discount_rate         AS discount_rate,\n" +
                "\n" +
                "\n" +
                "       I.member_discount_price AS member_discount_price,\n" +
                "       I.created_at            AS created_at,\n" +
                "       I.items_img_url         AS items_img_url,\n" +
                "       A.category              AS category,\n" +
                "       SC.category             AS sub_category,\n" +
                "       I.coupon                AS coupon,\n" +
                "       I.present               AS present\n" +
                "FROM CATEGORY A LEFT JOIN SUB_CATEGORY SC on A.id = SC.category_id LEFT JOIN ITEMS I on SC.id = I.sub_id\n" +
                "WHERE I.id=?"; //쿼리문 실행 DB 내 items_id로 조회
        int getItemParams = itemonea;
        return this.jdbcTemplate.queryForObject(getItemQuery,
                (rs, rowNum) -> new GetItemRes(
                        rs.getInt("itemId"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getString("discount_rate"),
                        rs.getInt("member_discount_price"),
                        rs.getTimestamp("created_at"),
                        rs.getString("items_img_url"),
                        rs.getString("category"),
                        rs.getString("sub_category"),
                        rs.getInt("coupon"),
                        rs.getInt("present")
                ),
                getItemParams);
    }


//아이템 조회 백업
//    public GetUserRes getUser(int userIdx){
//        String getUserQuery = "select * from Profiles where IDX = ?";
//        int getUserParams = userIdx;
//        return this.jdbcTemplate.queryForObject(getUserQuery,
//                (rs, rowNum) -> new GetUserRes(
//                        rs.getInt("IDX"),
//                        rs.getTimestamp("CREATE_AT"),
//                        rs.getTimestamp("UPDATE_AT"),
//                        rs.getString("userNickName"),
//                        rs.getString("imgUrl"),
//                        rs.getString("mannerTemp"),
//                        rs.getString("retradeRate"),
//                        rs.getString("responeRate"),
//                        rs.getInt("productSaleNum")),
//                getUserParams);
//    }
//아이템 조회 백업


//
    public int createUser(PostHowIdReq postUserReq){
        String createUserQuery = "insert into Profiles (IDX, userNickName, imgUrl, mannerTemp, retradeRate, responeRate, productSaleNum ) VALUES (?,?,?,?,?,?,?)";
        Object[] createUserParams = new Object[]{postUserReq.getIdx(), postUserReq.getUser_nick_name(), postUserReq.getImg_url(), postUserReq.getManner_temp(), postUserReq.getRetrade_rate(), postUserReq.getRespone_rate(),postUserReq.getProduct_sale_num()};
        this.jdbcTemplate.update(createUserQuery, createUserParams);

        String lastInserIdQuery = "select last_insert_id()";
        return this.jdbcTemplate.queryForObject(lastInserIdQuery,int.class);
    }
//
    public int checkEmail(String email){
        String checkEmailQuery = "select exists(select user_nick_name from Profiles where user_nick_name = ?)"; // userInfo에서 Profiles로 고침
        String checkEmailParams = email;
        return this.jdbcTemplate.queryForObject(checkEmailQuery,
                int.class,
                checkEmailParams);

    }

    public int modifyUserName(PatchUserReq patchUserReq){
        String modifyUserNameQuery = "update UserInfo set userName = ? where userIdx = ? ";
        Object[] modifyUserNameParams = new Object[]{patchUserReq.getUserName(), patchUserReq.getUserIdx()};

        return this.jdbcTemplate.update(modifyUserNameQuery,modifyUserNameParams);
    }

    public User getPwd(PostHowReq postLoginReq){
        String getPwdQuery = "select IDX, userNickName,imgUrl,mannerTemp, password from Profiles where IDX = ?";
        String getPwdParams = postLoginReq.getId();    //ID를 USER에는 int형으로로 정의했는데, 왜 PostLoginReq에는 ID를 String형으로 정의했나요?
                                                        //지금 이 쿼리문 자체가 IDX(기본키)를 통해 progiles 테이블에서 칼럼들을 뽑아오는건데,
                                                        //과제 영상에서 사용된 ID는 IDX(기본키)가 아니라 닉네임(iD)를 말하는 것입니다.
                                                        //물론 처음엔 어려우니, IDX(기본키)로 해보셔도 좋습니다.
                                                        //하지만, PostloginReq의 idx 자료형을 int형으로 바꿔주어야 곘죠. 왜냐하면 idx는 int형이니까~~~~~~~~~~~

        return this.jdbcTemplate.queryForObject(getPwdQuery,
                (rs,rowNum)-> new User(
                        rs.getInt("IDX"),
                        rs.getString("userNickName"),
                        rs.getString("imgUrl"),
                        rs.getString("mannerTemp"),
                        rs.getString("password")
                ),
                getPwdParams
                );

    }

    // 72번 API

    public List<GetNoticeRes> getNotice(){
        String getNoticeQuery = "select N.time AS time , N.description AS title\n" +
                "from NOTICES N;";
        return this.jdbcTemplate.query(getNoticeQuery,
                (rs,rowNum) -> new GetNoticeRes(
                        rs.getString("time"),
                        rs.getString("title")
                )
        );
    }
//


}
