package org.zerock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController5 {
	
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		/* 메서드 선언에 사용된 리턴타입을 보면 독특하게 @ResponseBody 어노테이션이 사용됨. 리턴타입도 일반 객체... 
		 * 이 때문에 doJSON 호출하면 객체가 리턴된다.
		 */
		ProductVO vo = new ProductVO("샘플상품", 30000);
		
		return vo;
		
	}
}
