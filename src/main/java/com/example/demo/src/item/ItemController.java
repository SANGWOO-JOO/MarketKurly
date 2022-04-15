package com.example.demo.src.item;

import com.example.demo.src.item.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/app")
public class ItemController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final ItemProvider itemProvider;
    @Autowired
    private final ItemService itemService;
    @Autowired
    private final JwtService jwtService;




    public ItemController(ItemProvider itemProvider, ItemService itemService, JwtService jwtService){
        this.itemProvider = itemProvider;
        this.itemService = itemService;
        this.jwtService = jwtService;
    }

    /**
     * 회원 조회 API
     * [GET] /users
     * 회원 번호 및 이메일 검색 조회 API
     * [GET] /users? Email=
     * @return BaseResponse<List<GetUserRes>>
     */
    //Query String
    // API 명세서 41번
    @ResponseBody
    @GetMapping("/item") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemRes>> getItems() { //성공여부 매핑
        try{
            List<GetItemRes> getItemsRes = itemProvider.getItems();
            return new BaseResponse<>(getItemsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //Query String
    // API 명세서 49번
    @ResponseBody
    @GetMapping("/items/new") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemRes>> getNew() { //성공여부 매핑
        try{
            List<GetItemRes> getItemsRes = itemProvider.getNew();
            return new BaseResponse<>(getItemsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //Query String
    // API 명세서 50번
    @ResponseBody
    @GetMapping("/items/popular") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemRes>> getBest() { //성공여부 매핑
        try{
            List<GetItemRes> getItemsRes = itemProvider.getBest();
            return new BaseResponse<>(getItemsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //Query String
    // API 명세서 51번
    @ResponseBody
    @GetMapping("/items/discount") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemRes>> getDiscount() { //성공여부 매핑
        try{
            List<GetItemRes> getItemsRes = itemProvider.getDiscount();
            return new BaseResponse<>(getItemsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //Query String
    // API 명세서 52번
    @ResponseBody
    @GetMapping("/items/lowprice") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemRes>> getRp() { //성공여부 매핑
        try{
            List<GetItemRes> getItemsRes = itemProvider.getRp();
            return new BaseResponse<>(getItemsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    //Query String
    // API 명세서 53번
    @ResponseBody
    @GetMapping("/items/highprice") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemRes>> getHp() { //성공여부 매핑
        try{
            List<GetItemRes> getItemsRes = itemProvider.getHp();
            return new BaseResponse<>(getItemsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }



    //Query String
    // API 명세서 45번
    @ResponseBody
    @GetMapping("/item/category") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetCategoryRes>> getCaa() { //성공여부 매핑
        try{
            List<GetCategoryRes> getCategoryRes = itemProvider.getCaa();
            return new BaseResponse<>(getCategoryRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //Query String
    // API 명세서 46번
    @ResponseBody
    @GetMapping("/category/all") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetCaAllReS>> getCaall() { //성공여부 매핑
        try{
            List<GetCaAllReS> getCaAllReS = itemProvider.getCaall();
            return new BaseResponse<>(getCaAllReS);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    //Query String
    // API 명세서 47번
    @ResponseBody
    @GetMapping("/category/where") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetCaWhereRes>> getCawhere() { //성공여부 매핑
        try{
            List<GetCaWhereRes> getCaWhereRes = itemProvider.getCawhere();
            return new BaseResponse<>(getCaWhereRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


// 2. 주제별 API 생성 (새로 만드는거)
//62번 주제별 API 전체 검색
    @ResponseBody
    @GetMapping("/subject/all") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetHomeCategoryRes>> getHc() { //성공여부 매핑
        try{
            List<GetHomeCategoryRes> getHomeCategoryRes = itemProvider.getHc();
            return new BaseResponse<>(getHomeCategoryRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    @ResponseBody
    @GetMapping("/subject/every") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetHowRes>> getAll() { //성공여부 매핑
        try{
            List<GetHowRes> getHowsRes = itemProvider.getAll();
            return new BaseResponse<>(getHowsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

//    API 64번
    @ResponseBody
    @GetMapping("/subject/howthis") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetHowRes>> getHows() { //성공여부 매핑
        try{
            List<GetHowRes> getHowsRes = itemProvider.getHows();
            return new BaseResponse<>(getHowsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //    API 65번
    @ResponseBody
    @GetMapping("/subject/newyear") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetHowRes>> getNy() { //성공여부 매핑
        try{
            List<GetHowRes> getHowsRes = itemProvider.getNy();
            return new BaseResponse<>(getHowsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    //    API 66번
    @ResponseBody
    @GetMapping("/subject/regret") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetHowRes>> getRg() { //성공여부 매핑
        try{
            List<GetHowRes> getHowsRes = itemProvider.getRg();
            return new BaseResponse<>(getHowsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //    API 67번
    @ResponseBody
    @GetMapping("/subject/deadline") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetHowRes>> getDl() { //성공여부 매핑
        try{
            List<GetHowRes> getHowsRes = itemProvider.getDl();
            return new BaseResponse<>(getHowsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    //    API 68번
    @ResponseBody
    @GetMapping("/subject/review") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetHowRes>> getRv() { //성공여부 매핑
        try{
            List<GetHowRes> getHowsRes = itemProvider.getRv();
            return new BaseResponse<>(getHowsRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    //    API 70번
    @ResponseBody
    @GetMapping("/items/reviews") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetReviewRes>> getRvs() { //성공여부 매핑
        try{
            List<GetReviewRes> getReviewRes = itemProvider.getRvs();
            return new BaseResponse<>(getReviewRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //    API 71번 상품 검색
    @ResponseBody
    @GetMapping("/items") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetReviewRes>> getReviewSearch(@RequestParam("review") String Rv) { //성공여부 매핑
        try{
            List<GetReviewRes> getReviewRes = itemProvider.getReviewSearch(Rv);
            return new BaseResponse<>(getReviewRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    //    API homesubject 검색
    @ResponseBody
    @GetMapping("/subject") // (GET) 127.0.0.1:9000/app/items

// subjectId
    public BaseResponse<List<GetHomeLogicRes>> getTest(@RequestParam("id")int Te) { //성공여부 매핑
        try{
            List<GetHomeLogicRes> getHomeLogicRes = itemProvider.getTest(Te);
            return new BaseResponse<>(getHomeLogicRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    @ResponseBody
    @GetMapping("/search") // (GET) 127.0.0.1:9000/app/items

// subjectId
    //69번
    public BaseResponse<List<GetSearchRes>> getSearch(@RequestParam("item") String Se) { //성공여부 매핑
        try{
            List<GetSearchRes> getSearchRes = itemProvider.getSearch(Se);
            return new BaseResponse<>(getSearchRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
    @ResponseBody
    @GetMapping("/category") // (GET) 127.0.0.1:9000/app/items
    // subjectId
    //48번
    public BaseResponse<List<GetCaWhereRes>> getSensitive(@RequestParam("subcategoryName") String Category) { //성공여부 매핑
        try{
            List<GetCaWhereRes> getCaWhereRes = itemProvider.getSensitive(Category);
            return new BaseResponse<>(getCaWhereRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }



    @ResponseBody
    @GetMapping("/category/{How}")
    public BaseResponse<GetHowRes> getHow(@PathVariable("How") int HOW) {
        try{
            GetHowRes getHowRes = itemProvider.getHow(HOW);
            return new BaseResponse<>(getHowRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    // 카테고리 별

//    @ResponseBody
//    @PostMapping("/HOW")
//    public BaseResponse<GetHowRes> getHow(@RequestBody PostHowReq postLoginReq){
//        try{
//            // TODO: 로그인 값들에 대한 형식적인 validatin 처리해주셔야합니다!
//            // TODO: 유저의 status ex) 비활성화된 유저, 탈퇴한 유저 등을 관리해주고 있다면 해당 부분에 대한 validation 처리도 해주셔야합니다.
//            PostLoginRes postLoginRes = itemProvider.logIn(postLoginReq);
//            return new BaseResponse<>(postLoginRes);
//        } catch (BaseException exception){
//            return new BaseResponse<>(exception.getStatus());
//        }
//    }


    //42번 아이템 조회(+검색)API

    @ResponseBody
    @GetMapping("/item/{ItemId}")
    public BaseResponse<GetItemRes> getItemone(@PathVariable("ItemId") int itemonea) { //Items DTO 받는거 아님
        try{
            GetItemRes getItemRes = itemProvider.getItemone(itemonea);
            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

    /**
     * 상품설명 조회 API
     * [GET] /users
     * 회원 번호 및 이메일 검색 조회 API
     * [GET] /users? Email=
     * @return BaseResponse<List<GetUserRes>>
     */
    //Query String
    @ResponseBody
    @GetMapping("/more/itemsmores") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetItemMoreRes>> getItemsmores() { //성공여부 매핑
        try{
            List<GetItemMoreRes> getItemMoreRes = itemProvider.getItemsmores();
            return new BaseResponse<>(getItemMoreRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


        /**
     * 상품설명 1개 조회 API
     * [GET] /items/:itemId
     * @return BaseResponse<GetUserRes>
     */

    @ResponseBody
    @GetMapping("/more/{ItemMore}")
    public BaseResponse<GetItemMoreRes> getItemMore(@PathVariable("ItemMore") int IDX) {
        try{
            GetItemMoreRes getItemMoreRes = itemProvider.getItemMore(IDX);
            return new BaseResponse<>(getItemMoreRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }

    }
    //Query String
    //
    @ResponseBody
    @GetMapping("/notice") // (GET) 127.0.0.1:9000/app/items
    public BaseResponse<List<GetNoticeRes>> getNotice() { //성공여부 매핑
        try{
            List<GetNoticeRes> getNoticeRes = itemProvider.getNotice();
            return new BaseResponse<>(getNoticeRes);
            // Get Users
//            List<GetUserRes> getItemRes = userProvider.getUsersByEmail(Email);
//            return new BaseResponse<>(getItemRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


//    //    /**
////     * 회원가입 API
////     * [POST] /users
////     * @return BaseResponse<PostUserRes>
////     */
//    // Body
//    @ResponseBody
//    @PostMapping("")
//    public BaseResponse<PostUserRes> createUser(@RequestBody PostHowIdReq postUserReq) {
//        // TODO: email 관련한 짧은 validation 예시입니다. 그 외 더 부가적으로 추가해주세요!
//        if(postHowIReq.getUsernickname() == null){
//            return new BaseResponse<>(POST_USERS_EMPTY_NICK_NAME);
//        }
//        //이메일 정규표현
////        if(!isRegexEmail(postUserReq.getUsernickname())){
////            return new BaseResponse<>(POST_USERS_INVALID_EMAIL);
////        }
//        try{
//            PostUserRes postUserRes = ItemService.createUser(postUserReq); //userService.createUser(postUserReq)로 이동
//            return new BaseResponse<>(postUserRes);
//        } catch(BaseException exception){
//            return new BaseResponse<>((exception.getStatus()));
//        }
//    }


}
