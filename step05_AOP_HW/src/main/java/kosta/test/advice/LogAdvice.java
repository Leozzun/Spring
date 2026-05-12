package kosta.test.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
public class LogAdvice {
	public LogAdvice() {
		
	}
	
	@Around("")
	public Object around(ProceedingJoinPoint joinPoint) {
		
		System.out.println("LogAdvice의 around 사전처리입니다.\n");
		
		Object re = joinPoint.proceed();
		
		System.out.println("LogAdvice의 around 사후처리입니다.\n");
		
		return re;
	}
}
