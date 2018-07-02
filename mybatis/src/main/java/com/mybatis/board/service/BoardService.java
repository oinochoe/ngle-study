package com.mybatis.board.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mybatis.board.VO.BoardVO;
import com.mybatis.board.VO.FileVO;
import com.mybatis.board.mapper.BoardMapper;

@Service("com.mybatis.board.service.BoardService")
public class BoardService {
	
	//의존성 주입 @Resource 는 자바 표준 @Autowired 는 스프링이 제공.
    @Resource(name="com.mybatis.board.mapper.BoardMapper")
    BoardMapper mBoardMapper;
    
    public List<BoardVO> boardListService() throws Exception{
        
        return mBoardMapper.boardList();
    }
    
    public BoardVO boardDetailService(int bno) throws Exception{
        
        return mBoardMapper.boardDetail(bno);
    }
    
    public int boardInsertService(BoardVO board) throws Exception{
        
        return mBoardMapper.boardInsert(board);
    }
    
    public int boardUpdateService(BoardVO board) throws Exception{
        
        return mBoardMapper.boardUpdate(board);
    }
    
    public int boardDeleteService(int bno) throws Exception{
        
        return mBoardMapper.boardDelete(bno);
    }
    
    //파일업로드
    public int fileInsertService(FileVO file) throws Exception{
    	
        return mBoardMapper.fileInsert(file);
    }
    
    //파일 다운로드
    public FileVO fileDetailService(int bno) throws Exception{
    	
        return mBoardMapper.fileDetail(bno);
    }

    
}
