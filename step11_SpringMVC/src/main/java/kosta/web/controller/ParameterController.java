package kosta.web.controller;

import java.util.Arrays;
import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kosta.web.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/param")
@Slf4j
public class ParameterController {
	
	//Logger log = LoggerFactory.getLogger(getClass());

	@GetMapping("/a.do")
	//public String test(String name, int age) {
	public String test(String name, Integer age) { // 없으면 null, 있으면 값으로 대응
		//System.out.println("되니?");
		log.info("ParameterController a.do 요청됨");
		log.info("name = {}, age={}", name, age);
		
		return "result"; // /WEB-INF/views/result.jsp
	}
	
	@RequestMapping("/b.do")
	public String bb(@RequestParam(value = "userId") String id, 
								@RequestParam(defaultValue = "0") int age) {
		
		log.info("param/b.do요청됨.");
		log.info("id ={}, age={}", id, age);
		
		return "result"; 
	}
	
	/**
	 * void 이므로 뷰페이지 /WEB-INF/views/param/user.jsp 이동
	 * 
	 * 인수로 parameter로 전달되어지는 이름과 속성이 일치하는 객체타입을 선언하면 
	 * 값들이 setter메소드에 바인딩된다.
	 * 
	 * 바인딩된 객체타입은 뷰쪽으로 전달된다!(Model에 저장이된다.)
	 * 뷰에서 ${객체이름.속성} 접근가능 -> 객체 이름은 객체 이름 첫글자 소문자 
	 * ex) UserDTO는 ${userDTO.속성} 이렇게 하면 userDTO.getXxx()  호출 된다.
	 */
	@PostMapping("/user.do")
	//public void user(UserDTO dto) {
	public void user(@ModelAttribute("dto") UserDTO dto) {
		log.info("dto={}", dto); // dto.toString()
	}
	
	/** 
	 * 현재 컨트롤러를 실행하는 모든 뷰의 공유 데이터 설정
	 */
	@ModelAttribute("msg") // 뷰에서 ${msg}
	public String message() {
		return "졸지맙시다!!";
	}
	
	@ModelAttribute("hobbysList") // 뷰에서 ${hobbysList}
	public List<String> list() {
		return Arrays.asList("A", "B", "C");
	}
}


/**
 * @ModelAttribute	
 * 1) 메소드 선언부 위에 작성
 *  	=> 현재 컨트롤러
 *  
 *  2) 매개변수 옆에 작성
 *  	=> 뷰쪽으로 전달되는 객체의 정보에 별칭 설정할때 사용
 */
