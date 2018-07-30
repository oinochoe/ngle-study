package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController3 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	@RequestMapping("/doD")
	public String doD(Model model) {
		//파라미터 Model 은 스프링에서 기본적으로 제공하며 .. 이 클래스는 뷰에 원하는 데이터를 전달하는 일종의 컨테이너나 상자역할
		
		//make sample data
		ProductVO product = new ProductVO("Sample Product", 10000);
		
		logger.info("doD");
		
		model.addAttribute(product);
		// 이름, 객체 대신에 객체만 있으므로 자동으로 뷰에서의 이름은 'productVO'가 됩니다. (클래스의 앞글자만 소문자로 바꾸면 뷰에서의 이름이 된다.)
		
		
		return "productDetail";
	}
	
}
