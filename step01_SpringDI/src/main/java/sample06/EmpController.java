package sample06;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {
	
	@Autowired //byType을 기준으로 객체를 찾아서 주입해줘.
	private EmpDTO empDto;
	
	@Autowired
	@Qualifier("dto2") //id가 dto2인 객체를 찾아서 empDto2에 주입
	private EmpDTO empDto2;
	
	@Autowired //set, 생성자 필요없다 (xml에서도 간결) 
	private EmpService empService;
	
	public EmpController() {
		System.out.println("EmpController 기본생성자 입니다.");
		
		System.out.println("empDto = " + empDto);
		System.out.println("empDto2 = " + empDto2);
		System.out.println("empService = " + empService);
	}
	
//	주입은 객체가 생성된 후에 주입이 된다!
//	@PostConstruct 는 생성과 주입이 완료된 후에 해야할 일이 있을때
//	메소드 위에 선언하면 자동으로 호출된다
//	<dependency>
//		<groupId>javax.annotation</groupId>
//		<artifactId>javax.annotation-api</artifactId>
//		<version>1.3.2</version>
//		<scope>compile</scope>
//	</dependency>
//	추가해야한다 
	
	@PostConstruct
	public void aa() {
		System.out.println("--aa 호출 ---");
		System.out.println("empDto = " + empDto + ", " + empDto.getEmpno());
		System.out.println("empDto2 = " + empDto2 + ", " + empDto2.getEmpno());
		System.out.println("empService = " + empService);
	}
	
	public void test() {
		System.out.println("EmpController test call");
		
		empService.test(empDto);
	}
}
