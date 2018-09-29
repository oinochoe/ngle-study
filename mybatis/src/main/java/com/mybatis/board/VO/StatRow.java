package com.mybatis.board.VO;

import lombok.Data;

@Data
public class StatRow {
    private final String name;
    private final int value1;
    private final int value2;

    public StatRow(String name, int value1, int value2) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }
}
