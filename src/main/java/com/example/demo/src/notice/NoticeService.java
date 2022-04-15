package com.example.demo.src.notice;

import com.example.demo.config.BaseException;
import com.example.demo.src.notice.model.NoticeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeDao noticeDao;
    public int createNotice(NoticeReq noticeReq) throws BaseException {

            int categoryRes = noticeDao.createNotice(noticeReq);
            return categoryRes;


    }


}
