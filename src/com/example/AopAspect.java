package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopAspect {
	
	/*
	 * execution target 
	 * Any method that satisfies this signature
	 *  "*" for all return types
	 * */
	@Pointcut("execution(* com.example.MessageService.getMessage(..))")
	public void pointCutMethod(){
		
	}
	
	@Before("pointCutMethod()")
	public void beforeEntry(){
		System.out.println("Hello from before advice of AopAspect");
	}
	
	@After("pointCutMethod()")
	public void afterExit(){
		System.out.println("Hello from after advice of AopAspect");
	}
	
	/**
	 * method is passed as jointPoint
	 * @param jointPoint
	 */
	@Around("pointCutMethod()")
	public Object doSomethingAround(ProceedingJoinPoint jointPoint){
		System.out.println("Around-Before");
		Object retval = null;
		try {
			System.out.println(jointPoint.getTarget());
			retval = jointPoint.proceed();
			retval = ((String) retval).toUpperCase();
		}catch(Throwable t){
			System.out.println("Something went wrong");
		}
		
		System.out.println("Around-After");
		return retval;
	}

}
