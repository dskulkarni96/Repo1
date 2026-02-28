package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectService {
	
	@Before(value = "execution (* com.example.demo.service.PlayerService.*(..))")
	public void beforeAspect(JoinPoint jp) {
		System.out.println(jp.getSignature() + " AND " + new java.util.Date());
	}
	@After(value = "execution (* com.example.demo.service.PlayerService.*(..))")
	public void afterAspect(JoinPoint jp) {
		System.out.println(jp.getSignature() + " AND " + new java.util.Date());
	}
	@AfterReturning(value = "execution (* com.example.demo.service.PlayerService.*(..))")
	public void afterReturniongAspect(JoinPoint jp) {
		System.out.println(jp.getSignature() + " AND " + new java.util.Date());
	}

}
