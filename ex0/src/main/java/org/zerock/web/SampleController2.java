package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController2 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	//String이 리턴 타입인 경우...
	@RequestMapping("doC")
	public String doC( @ModelAttribute("msg") String msg) {
		/* 
		 * @ModelAttribute는 다른 말로 커맨드 오브젝트라고도 불리는데 
		 * 그 이유는 클라이언트가 전달하는 파라미터를 1:1로 전담 프로퍼티에 담아내는 방식이 커맨드 패턴 그 자체이기 때문이다. 
		 * 여기서는 요청(request)시 'msg'이름의 파라미터를 문자열로 처리해주고 뷰에 전달해주는 역할을 합니다. 
		 * IOC가 일어난다고 할 수 있습니다.(스프링에서 처리해줌)
		 */
		
		logger.info("doC called....");
		
		return "result";
	}
	
}
