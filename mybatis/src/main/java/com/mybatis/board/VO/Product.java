package com.mybatis.board.VO;

import lombok.Data;
import org.apache.poi.ss.usermodel.Row;

@Data
public class Product {

    private String uniqueId;
    private String name;
    private String comment;

    protected Product() { }

    public Product(String uniqueId, String name, String comment) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.comment = comment;
    }

    public static Product ofRow(Row row) {
        return new Product(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue(), row.getCell(2).getStringCellValue());
    }
}