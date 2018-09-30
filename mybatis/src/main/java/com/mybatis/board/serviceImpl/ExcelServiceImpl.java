package com.mybatis.board.serviceImpl;


import com.mybatis.board.Dao.ExcelDao;
import com.mybatis.board.service.ExcelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service(value="excelService")
public class ExcelServiceImpl implements ExcelService {

    @Resource
    private ExcelDao excelDao;

    @Override
    public List<Object> getAllObjects(String target, Map<String, Object> searchMap) {

        // controller에서 넘어온 target에 따라서 dao 실행을 구분
        if (target.equals("books")){
            return excelDao.getBooks(searchMap); // 검색 조건 searchMap을 넘겨줌
        }
        /*if (target.equals("booksDetail")) {
            return excelDao.getBooksDetail(searchMap); // 검색 조건 searchMap을 넘겨줌
        }*/
        return null;
    }
}
