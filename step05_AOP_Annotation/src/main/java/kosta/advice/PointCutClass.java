package kosta.advice;

import org.aspectj.lang.annotation.Pointcut;

/**
 * pointcut 정의 하는 클래스
 */
public class PointCutClass {
	/**
	 * log 기록을 할 포인트 컷 정의
	 */
	@Pointcut("execution( * kosta.service.CustomerService.*(..))")
	public void aa() {
		
	}
	
	/**
	 * transaction 처릴할 포인트 컷
	 */
	@Pointcut("execution( * kosta.service.CustomerService.*())")
	public void bb() {
		
	}
	
	/**
	 * timer체크를 할 포인트 컷
	 */
//	@Pointcut("execution( * kosta.service.GoodsService.*(..))")
//	public void cc() {
//		
//	}
}
