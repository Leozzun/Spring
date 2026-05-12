package kosta.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ExceptionController {	
	
	@RequestMapping("/exception.do")
	public String test(String no) {
		log.info("no={}", no);
		
		//문자열 -> 숫자 변환
		int conovertNo = Integer.parseInt(no);
		log.info("conovertNo={}", conovertNo);
		
		return "result"; // WEB-INF/views/result.jsp
		
		/**
		 * 예외처리
		 * 1) 각 Controller마다 예외처리 (클래스 단위)
		 * 		=> 메소드를 작성하고 메소드 위에 @ExceptionHanlder 선언
		 * 
		 * 2) 하나의 프로젝트에 global(전역)예외처리
		 * 
		 */
	}
	
	@ExceptionHandler({NumberFormatException.class})
	public ModelAndView error(NumberFormatException e) {
		log.info("error Msg : {}", e.getMessage());
		
		//예외가 발생했을때 해야할일(catch 영역)
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/errorView");
		mv.addObject("errMsg", e.getMessage());
		mv.addObject("errClass", e.getClass().getName());
		mv.addObject("statusCode", HttpStatus.BAD_REQUEST);
		
		return mv;
	}
}

