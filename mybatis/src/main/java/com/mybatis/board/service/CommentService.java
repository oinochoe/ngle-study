package com.mybatis.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mybatis.board.VO.CommentVO;
import com.mybatis.board.mapper.CommentMapper;

@Service("com.mybatis.board.service.CommentService")
public class CommentService {
 
    @Resource(name="com.mybatis.board.mapper.CommentMapper")
    CommentMapper mCommentMapper;
    
    public List<CommentVO> commentListService(CommentVO comment) throws Exception{ // 컨트롤러에서 받아온 값을 서비스 처리.
        
        return mCommentMapper.commentList(comment); // 빈객체로 만들지말고 유의미하게 만들기 위해 파라미터 값 comment를 심어라.
    }
    
    public int commentInsertService(CommentVO comment) throws Exception{
        
        return mCommentMapper.commentInsert(comment);
    }
    
    public int commentUpdateService(CommentVO comment) throws Exception{
        
        return mCommentMapper.commentUpdate(comment);
    }
    
    public int commentDeleteService(int cno) throws Exception{
        
        return mCommentMapper.commentDelete(cno);
    }
}
