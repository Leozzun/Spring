package kosta.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TimerAdvice {
	/**
	 * 공통기능(부가기능)
	 * 		: around방식(사전처리, 사후처리)
	 * 		
	 * 		: 기능	
	 * 			사전의 현재시간 구한다.
	 * 			사후에 현재 시간 구해서 사후 - 사전 핵심 기능을 실행한 실행시간을 측정한다.
	 * 	
	 * 			@param : ProceedingJoinPoint (사전, 사후일때 다음 target대상을 호출 할 수 있는 메소드를 제공한다)
	 * 									JoinPoint (타겟대상의 메소드에 대한 정보를 조회 할 수 있는 메소드 제공) 라는 객체를 상속받은 객체
	 * 
	 * 			@return : Object는 target대상이 리턴한 값을 리턴해준다.
	 */
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		//사전처리
		String methodName = joinPoint.getSignature().getName();
		System.out.println("[LOG]" + methodName + "호출되기 전입니다.");
		
		Object params [] = joinPoint.getArgs(); //타겟대상 메소드의 매개변수(인수) 조회
		for(Object param :params) {
			System.out.println(param);
		}
		
		//현재 시간을 구한다.
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object obj = joinPoint.proceed(); // 다음 advice or target method를 호출한다.
		
		//사후처리
		sw.stop();
		System.out.println("[LOG]" + methodName + "호출된 후 입니다.");
		System.out.println("[LOG]" + methodName + "의 총 실행 시간(ms) = " + sw.getTotalTimeMillis());
		System.out.println("[LOG]" + methodName + "의 리턴값 obj = " + obj);
		
		return obj;
	}
}
