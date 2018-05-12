package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop { // 이 클래스가 공통기능으로 쓸 proxy, 대행자!

	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable { // joingpoint = 핵심기능
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println( signatureStr + " is start.");
		long st = System.currentTimeMillis(); // 핵심코드(joinpoint) 실행전 시간
		
		try {
			Object obj = joinpoint.proceed(); // 핵심코드 실행
			return obj;
		} finally {
			long et = System.currentTimeMillis(); // 핵심코드(joinpoint) 실행후 시간
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st)); // 두 개를 빼면 = 경과시간
		}
		
	}
	
}
