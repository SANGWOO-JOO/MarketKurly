package com.example.demo.src.notice;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.notice.model.NoticeReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/notice")
@RequiredArgsConstructor
public class NoticeController {
    
    private final NoticeService noticeService;
    

    @ResponseBody
    @PostMapping("")
    public BaseResponse<Integer> createNotice(@RequestBody NoticeReq noticeReq) throws BaseException {
        try{
            int a = noticeService.createNotice(noticeReq);
            return new BaseResponse<>(a);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
