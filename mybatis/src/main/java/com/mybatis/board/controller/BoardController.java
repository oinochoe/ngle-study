package com.mybatis.board.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.mybatis.board.VO.BoardVO;
import com.mybatis.board.VO.FileVO;
import com.mybatis.board.service.BoardService;

@Controller
public class BoardController {
	
	    //@Autowired 어노테이션이 타입으로 자동 주입을 하는 반면, 
		//@Resource 어노테이션은 name속성을 통해 자동 주입을 실행한다
	    @Resource(name="com.mybatis.board.service.BoardService")
	    BoardService mBoardService;
	    
	    @RequestMapping("/list")
	    private String boardList(Model model) throws Exception{
	    	
	    	model.addAttribute("list", mBoardService.boardListService());
	    	
	    	return "list";
	    }
	    
	    //@RequestParam의 경우 url 뒤에 붙는 파라메터의 값을 가져올 때 사용을 합니다.
	    //@PathVariable의 경우 url에서 각 구분자에 들어오는 값을 처리해야 할 때 사용합니다
	    @RequestMapping("/detail/{bno}") 
	    private String boardDetail(@PathVariable int bno, Model model) throws Exception{
	    	
	        model.addAttribute("detail", mBoardService.boardDetailService(bno));
	        model.addAttribute("files", mBoardService.fileDetailService(bno));
	        
	        return "detail";
	    }
	    
	    @RequestMapping("/insert") 
	    private String boardInsertForm() throws FileNotFoundException{
	        
	        return "insert";
	    }
	    
	    //파일 업로드 디렉토리 설정(application-proeprties)
	    @Value("${file.upload.dir}")
	    String uploadFileDir;
	    
	    @RequestMapping("/insertProc")
	    //spring 3.1에 추가된 @RequestPart -- "multipart/form-data" 요청의 컨텐츠 대한 접근 제공
	    private String boardInsertProc(HttpServletRequest request, @RequestPart MultipartFile files)  throws FileNotFoundException{
	        
	        BoardVO board = new BoardVO();
	        FileVO  file  = new FileVO();
	        
	        board.setSubject(request.getParameter("subject"));
	        board.setContent(request.getParameter("content"));
	        board.setWriter(request.getParameter("writer"));
	        
	        
//	        if(files.isEmpty()){
	            try {
	            	int i = mBoardService.boardInsertService(board);
	            	System.out.println(i);
	            	// update 쿼리문으로 insert 했을 때 실패하면 에러가 나지 않는다.
	            	// 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
//	        }else{
	            
            if(!files.isEmpty()) {
	            	
	            String fileName = files.getOriginalFilename(); 
	            String fileNameExtension = FilenameUtils.getExtension(fileName).toLowerCase(); 
	            File destinationFile; 
	            String destinationFileName; 
	            
	            //String fileUrl = "E:\\KYM\\_www\\_02_study\\mybatis\\src\\main\\webapp\\WEB-INF\\uploadFiles\\";
	            
	            do { 
	                destinationFileName = RandomStringUtils.randomAlphanumeric(32) + "." + fileNameExtension; 
	                destinationFile = new File(uploadFileDir+ destinationFileName); 
	            } while (destinationFile.exists()); 
	            
	            destinationFile.getParentFile().mkdirs();
	            
	            try {
					files.transferTo(destinationFile);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	            
//	            try {
//					mBoardService.boardInsertService(board);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} //게시글 insert
	            
	            file.setBno(board.getBno());
	            file.setFileName(destinationFileName);
	            file.setFileOriName(fileName);
	            file.setFileUrl(uploadFileDir);
	            
	            try {
					mBoardService.fileInsertService(file);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //file insert
	        }
	        
	        return "redirect:/list";
	    }
	    
	    //게시글 수정
	    @RequestMapping("/update/{bno}")
	    private String boardUpdateForm(@PathVariable int bno, Model model) throws Exception{
	        
	        model.addAttribute("detail", mBoardService.boardDetailService(bno));
	        
	        return "update";
	    }
	    
	    @RequestMapping("/updateProc")
	    private String boardUpdateProc(HttpServletRequest request) throws Exception{
	        
	        BoardVO board = new BoardVO();
	        board.setSubject(request.getParameter("subject"));
	        board.setContent(request.getParameter("content"));
	        board.setBno(Integer.parseInt(request.getParameter("bno")));
	        
	        int i = mBoardService.boardUpdateService(board);
	        System.out.println(i);
	        
	        return "redirect:/detail/"+request.getParameter("bno"); 
	    }

	 
	    @RequestMapping("/delete/{bno}")
	    private String boardDelete(@PathVariable int bno) throws Exception{
	        
	        mBoardService.boardDeleteService(bno);
	        
	        return "redirect:/list";
	    }
	    
	    @RequestMapping("/fileDown/{bno}")
	    private void fileDown(@PathVariable int bno, HttpServletRequest request, HttpServletResponse response) throws Exception{
	        
	        request.setCharacterEncoding("UTF-8");
	        FileVO fileVO = mBoardService.fileDetailService(bno);
	        
	        //파일 업로드된 경로 
	        try{
	            String fileUrl = fileVO.getFileUrl();
	            fileUrl += "/";
	            String savePath = fileUrl;
	            String fileName = fileVO.getFileName();
	            
	            //실제 내보낼 파일명 
	            String oriFileName = fileVO.getFileOriName();
	            InputStream in = null;
	            OutputStream os = null;
	            File file = null;
	            boolean skip = false;
	            String client = "";
	            
	            //파일을 읽어 스트림에 담기  
	            try{
	                file = new File(savePath, fileName);
	                in = new FileInputStream(file);
	            } catch (FileNotFoundException fe) {
	                skip = true;
	            }
	            
	            client = request.getHeader("User-Agent");
	            
	            //파일 다운로드 헤더 지정 
	            response.reset();
	            response.setContentType("application/octet-stream");
	            response.setHeader("Content-Description", "JSP Generated Data");
	            
	            if (!skip) {
	                // IE
	                if (client.indexOf("MSIE") != -1) {
	                    response.setHeader("Content-Disposition", "attachment; filename=\""
	                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
	                // IE 11 이상.
	                } else if (client.indexOf("Trident") != -1) {
	                    response.setHeader("Content-Disposition", "attachment; filename=\""
	                            + java.net.URLEncoder.encode(oriFileName, "UTF-8").replaceAll("\\+", "\\ ") + "\"");
	                } else {
	                    // 한글 파일명 처리
	                    response.setHeader("Content-Disposition",
	                            "attachment; filename=\"" + new String(oriFileName.getBytes("UTF-8"), "ISO8859_1") + "\"");
	                    response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
	                }
	                
	                response.setHeader("Content-Length", "" + file.length());
	                os = response.getOutputStream();
	                byte b[] = new byte[(int) file.length()];
	                int leng = 0;
	                
	                while ((leng = in.read(b)) > 0) {
	                    os.write(b, 0, leng);
	                }
	                
	            } else {
	                response.setContentType("text/html;charset=UTF-8");
	                System.out.println("<script language='javascript'>alert('파일을 찾을 수 없습니다');history.back();</script>");
	            }
	            
	            in.close();
	            os.close();
	            
	        } catch (Exception e) {
	            System.out.println("ERROR : " + e.getMessage());
	        }
	        
	    }

}
