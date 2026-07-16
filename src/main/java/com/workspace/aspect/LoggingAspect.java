package com.workspace.aspect;

import org.springframework.stereotype.Component;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect //A class that contains common code
@Component
public class LoggingAspect 
{

//    @Before("execution(* com.workspace.service.*.*(..))")  //Before executing ANY method having ANY return type inside ANY class of the service package with ANY parameters
//    public void logBefore(JoinPoint joinPoint)
//    {
//        //System.out.println("Entering Method: " + joinPoint.getSignature().getName());
//        String className =
//                joinPoint.getTarget()
//                         .getClass()
//                         .getSimpleName();
//
//        String methodName =
//                joinPoint.getSignature()
//                         .getName();
//
//        System.out.println(
//            "Entering : "
//            + className
//            + "."
//            + methodName);
//    }
    
	@Pointcut("execution(* com.workspace.service.*.*(..))")
	public void serviceMethods()
	{

	}
	
	@Around("serviceMethods()")
	public Object logExecutionTime(
	        ProceedingJoinPoint joinPoint)
	        throws Throwable
	{
	    String className =
	            joinPoint.getTarget()
	                     .getClass()
	                     .getSimpleName();

	    String methodName =
	            joinPoint.getSignature()
	                     .getName();

	    long start = System.currentTimeMillis();

	    System.out.println(
	            "Entering : "
	            + className
	            + "."
	            + methodName);
	    System.out.println(
	            "Arguments : "
	            + Arrays.toString(joinPoint.getArgs()));


	    try
	    {
	        Object result = joinPoint.proceed();

	        System.out.println(
	                "Leaving : "
	                + className
	                + "."
	                + methodName);

	        return result;
	    }
	    catch(Exception e)
	    {
	        System.out.println(
	                "Exception : "
	                + e.getMessage());

	        throw e;
	    }
	    finally
	    {
	        long end =
	                System.currentTimeMillis();

	        System.out.println(
	                "Execution Time : "
	                + (end-start)
	                + " ms");
	    }
	}
}
