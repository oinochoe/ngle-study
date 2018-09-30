package com.mybatis.board.VO;

import lombok.Data;

import java.util.Date;

@Data
public class ExcelVO {
    private String MONTH_REPORT_ID;
    private Date SELLING_TIME;
    private String GAME_NAME;
    private String PARTNER_COMPNAY;
    private String CONTRACT_TYPE;
    private String SYSTEM_CURRENCY;
    private String PAY_CURRENCY;
    private String COUNTRY;
}
