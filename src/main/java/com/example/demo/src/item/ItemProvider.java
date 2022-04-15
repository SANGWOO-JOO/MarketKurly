package com.example.demo.src.item;


import com.example.demo.config.BaseException;
import com.example.demo.src.item.model.*;
import com.example.demo.src.user.model.PostHowReq;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.config.BaseResponseStatus.*;

//Provider : Read의 비즈니스 로직 처리
@Service
public class ItemProvider {

    private final ItemDao itemDao;
    private final JwtService jwtService;


    final Logger logger = LoggerFactory.getLogger(this.getClass()); // POST

    @Autowired
    public ItemProvider(ItemDao itemDao, JwtService jwtService) {
        this.itemDao = itemDao;
        this.jwtService = jwtService;
    }

//    /**
//     * 상품 전체 조회 API
//     */

    // API 명세서 41번

    public List<GetItemRes> getItems() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemRes> getItemRes = itemDao.getItems(); //Users -> Items로 변경
            return getItemRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

//49번 API

    public List<GetItemRes> getNew() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemRes> getItemRes = itemDao.getNew(); //Users -> Items로 변경
            return getItemRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //50번  API

    public List<GetItemRes> getBest() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemRes> getItemRes = itemDao.getBest(); //Users -> Items로 변경
            return getItemRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    //51번  API

    public List<GetItemRes> getDiscount() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemRes> getItemRes = itemDao.getDiscount(); //Users -> Items로 변경
            return getItemRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    //52번  API

    public List<GetItemRes> getRp() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemRes> getItemRes = itemDao.getRp(); //Users -> Items로 변경
            return getItemRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    //53번  API

    public List<GetItemRes> getHp() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemRes> getItemRes = itemDao.getHp(); //Users -> Items로 변경
            return getItemRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //Query String
    // API 명세서 45번
    public List<GetCategoryRes> getCaa() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetCategoryRes> getCategoryRes = itemDao.getCaa(); //Users -> Items로 변경
            return getCategoryRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    //Query String
    // API 명세서 46번
    public List<GetCaAllReS> getCaall() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetCaAllReS> getCaAllReS = itemDao.getCaall(); //Users -> Items로 변경
            return getCaAllReS; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    // API 명세서 47번
    public List<GetCaWhereRes> getCawhere() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetCaWhereRes> getCaWhereRes = itemDao.getCawhere(); //Users -> Items로 변경
            return getCaWhereRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

// 2. 주제별 API 생성

    public List<GetHomeCategoryRes> getHc() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHomeCategoryRes> getHomeCategoryRes = itemDao.getHc(); //Users -> Items로 변경
            return getHomeCategoryRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    //HOW 전체 조회 API

    public List<GetHowRes> getAll() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHowRes> getHowRes = itemDao.getAll(); //Users -> Items로 변경
            return getHowRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

//HOW 전체 조회 API
//API 64번
    public List<GetHowRes> getHows() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHowRes> getHowRes = itemDao.getHows(); //Users -> Items로 변경
            return getHowRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
    //HOW 전체 조회 API
//API 65번
    public List<GetHowRes> getNy() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHowRes> getHowRes = itemDao.getNy(); //Users -> Items로 변경
            return getHowRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


//API 66번
    public List<GetHowRes> getRg() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHowRes> getHowRes = itemDao.getRg(); //Users -> Items로 변경
            return getHowRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //API 67번
    public List<GetHowRes> getDl() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHowRes> getHowRes = itemDao.getDl(); //Users -> Items로 변경
            return getHowRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //API 68번
    public List<GetHowRes> getRv() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHowRes> getHowRes = itemDao.getRv(); //Users -> Items로 변경
            return getHowRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //API 70번
    public List<GetReviewRes> getRvs() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetReviewRes> getReviewRes = itemDao.getRvs(); //Users -> Items로 변경
            return getReviewRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //API 69번
    public List<GetReviewRes> getReviewSearch(String Rv) throws BaseException{ //Users -> Items로 변경
        try{
            List<GetReviewRes> getReviewRes = itemDao.getReviewSearch(Rv); //Users -> Items로 변경
            return getReviewRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

//API 69번
    public List<GetSearchRes> getSearch(String Se) throws BaseException{ //Users -> Items로 변경
        try{
            List<GetSearchRes> getSearchRes = itemDao.getSearch(Se); //Users -> Items로 변경
            return getSearchRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //API 48번
    public List<GetCaWhereRes> getSensitive(String Category) throws BaseException{ //Users -> Items로 변경
        try{
            List<GetCaWhereRes> getCaWhereRes = itemDao.getSensitive(Category); //Users -> Items로 변경
            return getCaWhereRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


    //API 69번
    public List<GetHomeLogicRes> getTest(int Te) throws BaseException{ //Users -> Items로 변경
        try{
            List<GetHomeLogicRes> getHomeLogicRes = itemDao.getTest(Te); //Users -> Items로 변경
            return getHomeLogicRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }



    public GetHowRes getHow(int HOW) throws BaseException {
        try {
            GetHowRes getHowRes = itemDao.getHow(HOW);
            return getHowRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }




    // 42번
    public GetItemRes getItemone(int itemonea) throws BaseException {
        try {
            GetItemRes getItemRes = itemDao.getItemone(itemonea);
            return getItemRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //    /**
//     * 상품설명 전체 조회 API
//     */
    public List<GetItemMoreRes> getItemsmores() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetItemMoreRes> getItemMoreRes = itemDao.getItemsmores(); //Users -> Items로 변경
            return getItemMoreRes;
            //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    //    // 상세상품 1개 조회
    public GetItemMoreRes getItemMore(int IDX) throws BaseException {
        try {
            GetItemMoreRes getItemMoreRes = itemDao.getItemMore(IDX);
            return getItemMoreRes;
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


//    // 상세상품 1개 조회
//    public GetItemMoreRes getItemMore(int IDX) throws BaseException {
//        try {
//            GetItemMoreRes getItemMoreRes = itemDao.getItemMore(IDX);
//            return getItemMoreRes;
//        } catch (Exception exception) {
//            throw new BaseException(DATABASE_ERROR);
//        }
//    }




//
    public int checkEmail(String email) throws BaseException{
        try{
            return itemDao.checkEmail(email);
        } catch (Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public PostLoginRes logIn(PostHowReq postLoginReq) throws BaseException{
        User user = itemDao.getPwd(postLoginReq);
        String password = user.getPassword();

        //이 부분은 회원가입이 완료된후 패스워드를 DB에서 복호화 할수 있을때 구현.
//        try {
//            password = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(user.getPassword());
//        } catch (Exception ignored) {
//            throw new BaseException(PASSWORD_DECRYPTION_ERROR);
//        }



        if(postLoginReq.getPassword().equals(password)){
            int userIdx = itemDao.getPwd(postLoginReq).getIDX();
            String jwt = jwtService.createJwt(userIdx);
            return new PostLoginRes(userIdx,jwt);
        }
        else{
            throw new BaseException(FAILED_TO_LOGIN);
        }

    }

    // API 명세서 41번

    public List<GetNoticeRes> getNotice() throws BaseException{ //Users -> Items로 변경
        try{
            List<GetNoticeRes> getNoticeRes = itemDao.getNotice(); //Users -> Items로 변경
            return getNoticeRes; //GetUserRes -> GetItemsRes
        }
        catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

//    //로그인
//    public PostLoginRes logIn(PostHowReq postLoginReq) throws BaseException{
////        User user = ItemDao.getPwd(postLoginReq);
////        String password;
////        try {
////            password = new AES128(Secret.USER_INFO_PASSWORD_KEY).decrypt(user.getPassword());
////        } catch (Exception ignored) {
////            throw new BaseException(PASSWORD_DECRYPTION_ERROR);
////        }
//
//        if(postLoginReq.getPassword().equals(password)){
//            int userIdx = ItemDao.getPwd(postLoginReq).getIDX();
//            String jwt = jwtService.createJwt(userIdx);
//            return new PostLoginRes(jwt, userIdx);
//        }
//        else{
//            throw new BaseException(FAILED_TO_LOGIN);
//        }

//    }


}
