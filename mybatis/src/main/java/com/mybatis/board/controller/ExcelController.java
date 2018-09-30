package com.mybatis.board.controller;

import com.mybatis.board.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class ExcelController {

    @Autowired
    ExcelService excelService;

    @RequestMapping("/excelDownload")
    public String excelTransform(@RequestParam Map<String, Object> paramMap, Map<String, Object> ModelMap, HttpServletResponse response) throws Exception {
        /**
         * excelDownload?target=books&id=b2
         * 위와 같은 형식으로 파라미터가 온다고 가정
         * target에 따라서 가져올 리스트 선택
         */
        String target = paramMap.get("target").toString();
        response.setHeader("Content-disposition", "attachment; filename=" + target + ".xlsx"); // target명을 파일명으로 작성

        // 엑셀에 작성할 리스트를 가져온다
        List<Object> excelList = excelService.getAllObjects(target, paramMap);

        // ExcelView(com.mybatis.board.view.ExcelView)에 넘겨줄 값 세팅
        ModelMap.put("excelList", excelList);
        ModelMap.put("target", target);

        return "excelView";

        // servlet-context.xml 에서 name이 excelView(com.mybatis.board.view.ExcelView) 인 것 호출
    }

}
