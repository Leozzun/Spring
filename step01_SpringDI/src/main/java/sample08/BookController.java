package sample08;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import lombok.RequiredArgsConstructor;

@Controller("controller")
@RequiredArgsConstructor //생성자
public class BookController {
	
	@Autowired
	private BookDTO book2;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookDTO book1;
	
	@PostConstruct
	public void init() {
		System.out.println("book1 = " + book1);
		System.out.println("book2 = " + book2);
	}
	
	public void invoker() {
		
		bookService.save(book1, book2);
		
	}
}
