package com.rise.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {
	

	@Around("execution(* com.encore.service.MsgService*.*(..))")//Before+After
	public Object startEndLog(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("===============<나 Before>==================");
		long start = System.currentTimeMillis();
		//실제 핵심메소드 호출!! 
		Object result = joinPoint.proceed();
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("["+joinPoint.getSignature().getName()+
				        "]메소드 실행시간: "+ (end-start));
		System.out.println("===============<나 After>==================");
		
		return result;
	}

}
