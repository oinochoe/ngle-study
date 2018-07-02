package com.mybatis.board.VO;

import java.util.Date;
import lombok.Data;

@Data
public class BoardVO {
    private int bno;
    private String subject;
    private String content;
    private String writer;
    private Date reg_date;
}


//domain(영역, 범위, 소유지)
//단위로 표현할 수 있고 원자성을 띄는 자바빈 클래스, enum 클래스 등이 위치한다.

//VO(Value Object)
//데이터 그 자체로 의미 있는 것을 담고 있는 객체. DTO와의 차이점은 Read-Only 속성 객체를 뜻한다. 보통 값 변경이 없는 경우.

//DTO(Data Trnasfer Object)
//전송되는 데이터의 컨테이너이다. 비지니스 로직까지 담아서 사용하기도 한다고 합니다.