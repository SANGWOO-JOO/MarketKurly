package com.example.demo.src.category;

import com.example.demo.config.BaseException;
import com.example.demo.src.category.model.CategoryReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryDao categoryDao;
    public int createCategory(CategoryReq categoryReq) throws BaseException {
//        try{
            int categoryRes = categoryDao.createCategory(categoryReq);
            return categoryRes;
//        }catch(Exception exception){
//            throw new BaseException(DATABASE_ERROR);
//        }

    }


}
