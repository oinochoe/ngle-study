package com.mybatis.board.service;

import java.util.List;
import java.util.Map;

public interface ExcelService {
    public List<Object> getAllObjects(String target, Map<String, Object> searchMap);
}
