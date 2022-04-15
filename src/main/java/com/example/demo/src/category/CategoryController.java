package com.example.demo.src.category;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.category.model.CategoryReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/category")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;
    

    @ResponseBody
    @PostMapping("")
    public BaseResponse<Integer> createCategory(@RequestBody CategoryReq categoryReq) throws BaseException {
        try{
            int a = categoryService.createCategory(categoryReq);
            return new BaseResponse<>(a);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
