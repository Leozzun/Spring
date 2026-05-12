package kosta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 생성
public class TestController {
	
	@RequestMapping("/test.do")
	public ModelAndView aa() {
		System.out.println("TestController의 test.do 요청됨..");
		
		return new ModelAndView("result", "message", "Spring재미있다!"); //뷰이름의 결과 prefix + 뷰이름 + suffix 조합
	}
}
