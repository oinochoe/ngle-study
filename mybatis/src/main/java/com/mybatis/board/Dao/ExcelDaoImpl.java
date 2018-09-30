package com.mybatis.board.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("excelDao")
public class ExcelDaoImpl implements ExcelDao{

    @Autowired
    private SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Object> getBooks(Map<String, Object> searchMap) {
        return sqlSession.selectList("selectBooks", searchMap);
    }

    /*@Override
    public List<Object> getBooksDetail(Map<String, Object> searchMap) {
        return sqlSession.selectList("selectBooksDetail", searchMap);
    }*/
}
