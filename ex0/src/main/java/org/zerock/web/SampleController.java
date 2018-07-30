package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//void 리턴 타입의 경우
@Controller //이 클래스를 컨트롤러로 설정하게 하는 어노테이션.
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA Called");
	}
	
	@RequestMapping("doB")
	public void doB() {
		logger.info("doB called...");
	}
	
}
