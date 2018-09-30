package com.mybatis.board.Dao;

import com.mybatis.board.VO.BoardVO;
import com.mybatis.board.VO.FileVO;
import com.mybatis.board.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


public interface ExcelDao {
    public List<Object> getBooks(Map<String, Object> searchMap);
    //public List<Object> getBooksDetail(Map<String, Object> searchMap);
}
