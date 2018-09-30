package com.mybatis.board.component;

import com.mybatis.board.constant.ExcelConstant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.apache.poi.hssf.record.ExtendedFormatRecord.VERTICAL_CENTER;
import static org.apache.poi.ss.usermodel.Font.BOLDWEIGHT_BOLD;

public class ExcelWriteComponent {

    private Workbook workbook;
    private Map<String, Object> model;
    private HttpServletResponse response;

    public ExcelWriteComponent(Workbook workbook, Map<String, Object> model, HttpServletResponse response) {
        this.workbook = workbook;
        this.model = model;
        this.response = response;
    }

    public void create() {
        setFileName(response, mapToFileName());

        Sheet sheet = workbook.createSheet();

        createHead(sheet, mapToHeadList());

        createBody(sheet, mapToBodyList());
    }

    private String mapToFileName() {
        return (String) model.get(ExcelConstant.FILE_NAME);
    }

    private List<String> mapToHeadList() {
        return (List<String>) model.get(ExcelConstant.HEAD);
    }

    private List<List<String>> mapToBodyList() {
        return (List<List<String>>) model.get(ExcelConstant.BODY);
    }

    private void setFileName(HttpServletResponse response, String fileName) {

        // 엑셀파일명
        String target = "엑셀파일명-" + getNowYMD() + ".xlsx";
        String docName = getFileExtension(fileName);
        try {
            docName =  URLEncoder.encode(target, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        response.setHeader("Content-Disposition", "attachment; filename=\"" + docName  + "\"");

        // 엑셀파일명 한글깨짐 조치
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        // 엑셀파일에 저장할 리스트를 가져온다.
        /*List<ExcelVO> excelList= brService.selectListForExcel();
        ModelMap.put("excelList", excelList);*/
    }

    private String getNowYMD() {
        StringBuffer dateResult = new StringBuffer();
        Date date = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
        simpleDate.format(date, dateResult, new FieldPosition(1));
        return dateResult.toString();
    }

    private String getFileExtension(String fileName) {
        if (workbook instanceof XSSFWorkbook) {
            fileName += ".xlsx";
        }
        if (workbook instanceof SXSSFWorkbook) {
            fileName += ".xlsx";
        }
        if (workbook instanceof HSSFWorkbook) {
            fileName += ".xls";
        }

        return fileName;
    }

    // head에 해당하는 데이터 삽입
    private void createHead(Sheet sheet, List<String> headList) {
        createRow(sheet, headList, 0);

        //List<ExcelVO> listBr = (List<ExcelVO>) model.get("excelList");
        // Sheet 생성
        sheet = workbook.createSheet("영민시트"); // 시트 생성
        sheet.setDisplayGridlines(false); // gridline 삭제
        Row row = null;
        Cell cell = null;
        int rowCount = 0;
        int cellCount = 0;

        // 첫번째 로우 폰트 설정
        Font headFont = workbook.createFont();
        headFont.setFontHeightInPoints((short) 12);
        headFont.setFontName("맑은고딕");
        headFont.setBoldweight(BOLDWEIGHT_BOLD);

        // 첫번째 로우 셀 스타일 설정
        CellStyle headStyle = workbook.createCellStyle();
        headStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        headStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headStyle.setAlignment(CellStyle.ALIGN_CENTER);
        headStyle.setVerticalAlignment(VERTICAL_CENTER);
        headStyle.setFont(headFont);
        headStyle.setBorderBottom(CellStyle.BORDER_THIN);
        headStyle.setBorderLeft(CellStyle.BORDER_THIN);
        headStyle.setBorderRight(CellStyle.BORDER_THIN);
        headStyle.setBorderTop(CellStyle.BORDER_THIN);

        // 바디 폰트 설정
        Font bodyFont = workbook.createFont();
        bodyFont.setFontHeightInPoints((short) 19);
        bodyFont.setFontName("맑은고딕");

        // 바디 스타일 설정
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setFont(bodyFont);
        bodyStyle.setWrapText(true);
        bodyStyle.setVerticalAlignment(VERTICAL_CENTER);
        bodyStyle.setBorderBottom(CellStyle.BORDER_THIN);
        bodyStyle.setBorderLeft(CellStyle.BORDER_THIN);
        bodyStyle.setBorderRight(CellStyle.BORDER_THIN);
        bodyStyle.setBorderTop(CellStyle.BORDER_THIN);

        CellStyle bodyStyleAlign = workbook.createCellStyle();
        bodyStyleAlign.setFont(bodyFont);
        bodyStyleAlign.setWrapText(true);
        bodyStyleAlign.setVerticalAlignment(VERTICAL_CENTER);
        bodyStyleAlign.setBorderBottom(CellStyle.BORDER_THIN);
        bodyStyleAlign.setBorderLeft(CellStyle.BORDER_THIN);
        bodyStyleAlign.setBorderRight(CellStyle.BORDER_THIN);
        bodyStyleAlign.setBorderTop(CellStyle.BORDER_THIN);
        bodyStyleAlign.setAlignment(CellStyle.ALIGN_CENTER);

        // 제목 셀 생성
        row = sheet.createRow(rowCount++);
        cell = row.createCell(cellCount++);
        cell.setCellStyle(headStyle);
        cell.setCellValue("샘플ID");
        cell = row.createCell(cellCount++);
        cell.setCellStyle(headStyle);
        cell.setCellValue("샘플명");

        // 데이터 셀 생성
        //for (ExcelVO excelVO : listBr) {

        row = sheet.createRow(rowCount++);
        row.setHeight((short)1000);
        cellCount = 0;
        int nCount = 0;

        // 아래 개행을 위한 로직은 조회해온 값에 개행이 포함되 있다면 처리하기 위함이니
        // 없는 분들은 삭제해도 좋다
        // 개행을 위한 로직
        /*String[] remark = excelVO.getBsrlvfnswprgdes().split("\\|");   //분리자 |*/
        String description = "";
        // 개행을 위한 로직(줄 높이 계산)
          /*  for (int k = 0; k < remark.length; k++)
            {
                if (remark[k].length() > 0)
                {
                    if (nCount == 0)
                        description += remark[k];
                    else
                        description += "\r\n"+ remark[k];
                    nCount++;
                }
            }*/
        // 개행을 위한 로직(줄 높이 설정)
        if (nCount > 1)
            row.setHeightInPoints((nCount * sheet.getDefaultRowHeightInPoints()));


        // 바디 셀에 데이터 입력, 스타일 적용
        cell = row.createCell(cellCount++);
        cell.setCellStyle(bodyStyle);
        //cell.setCellValue(excelVO.getBsrlid());
        cell = row.createCell(cellCount++);
        cell.setCellStyle(bodyStyle);
        //cell.setCellValue(excelVO.getBsrlnm());

        //}

        // 셀 와이드 설정
        for (int i = 0; i < 2; i++){
            sheet.autoSizeColumn(i, true);
            // 위의 내용만 적어도 되나 셀별로 원하는 와이드를 설정하려면 아래 코드를 이용하자
            if(i == 1){
                sheet.setColumnWidth(i, 8000);
            }
        }
    }

    /*protected Workbook createWorkbook() {
        return new XSSFWorkbook();
    }*/

    // body에 해당하는 데이터 삽입
    private void createBody(Sheet sheet, List<List<String>> bodyList) {
        int rowSize = bodyList.size();
        for (int i = 0; i < rowSize; i++) {
            createRow(sheet, bodyList.get(i), i + 1);
        }
    }

    // createHead, createBody에서 공통으로 쓰인 메소드
    private void createRow(Sheet sheet, List<String> cellList, int rowNum) {
        int size = cellList.size();
        Row row = sheet.createRow(rowNum);

        for (int i = 0; i < size; i++) {
            row.createCell(i).setCellValue(cellList.get(i));
        }
    }
}