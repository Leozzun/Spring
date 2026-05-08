package sample08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Component //생성 <bean class="BoardDTO" id="boardDTO"
@ToString
@Scope("prototype") //지연 초기화 / 객체의 주소 값을 다르게 해준다
public class BookDTO {
	
	private String subject;
	private String writer;
	private int price;
	private String date;
	
}
