package com.example.demo.src.item;



import com.example.demo.config.BaseException;
import com.example.demo.config.secret.Secret;
import com.example.demo.src.item.model.PostHowIdReq;
import com.example.demo.src.user.model.*;
import com.example.demo.utils.AES128;
import com.example.demo.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.config.BaseResponseStatus.*;

// Service Create, Update, Delete 의 로직 처리
@Service
public class ItemService {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ItemDao itemDao;
    private final ItemProvider itemProvider;
    private final JwtService jwtService;


    @Autowired
    public ItemService(ItemDao itemDao, ItemProvider itemProvider, JwtService jwtService) {
        this.itemDao = itemDao;
        this.itemProvider = itemProvider;
        this.jwtService = jwtService;

    }

    // 카테고리 별 생성 API

    //POST userService 클래스 내
    public PostUserRes createUser(PostHowIdReq postUserReq) throws BaseException { // Control 101
        //중복
        if (itemProvider.checkEmail(postUserReq.getUser_nick_name()) == 1) {
            throw new BaseException(POST_USERS_EXISTS_EMAIL);
        }

        String pwd;
        try{
            //암호화
            pwd = new AES128(Secret.USER_INFO_PASSWORD_KEY).encrypt(postUserReq.getPassword());
            postUserReq.setPassword(pwd);
        } catch (Exception ignored) {
            throw new BaseException(PASSWORD_ENCRYPTION_ERROR);
        }
        try {
            int IDX = itemDao.createUser(postUserReq);
            //jwt 발급.
            String jwt = jwtService.createJwt(IDX);
            return new PostUserRes(jwt, IDX);
        } catch (Exception exception) {
            throw new BaseException(DATABASE_ERROR);
        }
    }

    public void modifyUserName(PatchUserReq patchUserReq) throws BaseException {
        try{
            int result = itemDao.modifyUserName(patchUserReq);
            if(result == 0){
                throw new BaseException(MODIFY_FAIL_USERNAME);
            }
        } catch(Exception exception){
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
