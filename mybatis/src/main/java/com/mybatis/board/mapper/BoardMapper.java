package com.mybatis.board.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mybatis.board.VO.BoardVO;
import com.mybatis.board.VO.FileVO;

// @Repository -- 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시.
// 확장을 위해서 com ~ 부터 선언.
@Repository("com.mybatis.board.mapper.BoardMapper")
public interface BoardMapper {
	
    //게시글 목록  
    public List<BoardVO> boardList() throws Exception;
    
    //게시글 상세
    public BoardVO boardDetail(int bno) throws Exception;
    
    //게시글 작성  
    public int boardInsert(BoardVO board) throws Exception;
    
    //게시글 수정  
    public int boardUpdate(BoardVO board) throws Exception;
    
    //게시글 삭제  
    public int boardDelete(int bno) throws Exception;
    
    // 파일 업로드
    public int fileInsert(FileVO file) throws Exception;
    
    // 파일 다운로드 하기 위한 상세페이지
    public FileVO fileDetail(int bno) throws Exception;
  


}
	