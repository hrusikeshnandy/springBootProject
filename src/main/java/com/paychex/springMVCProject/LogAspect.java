package com.paychex.springMVCProject;



import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	@Before("execution(public * com.paychex.springMVCProject.AlienController.getAliens())")
	public void log() {
		logger.info("inside the log aspect class");
	}
	
	@After("execution(public * com.paychex.springMVCProject.AlienController.getAliens())")
	public void logAfter() {
		logger.info("method executed");
	}
	
	@AfterReturning("execution(public * com.paychex.springMVCProject.AlienController.getAliens())")
	public void logAfterReturn() {
		logger.info("method executed sucessfully");
	}
	
	@AfterThrowing("execution(public * com.paychex.springMVCProject.AlienController.getAliens())")
	public void logAfterThrow() {
		logger.info("issue is there in the code");
	}
}
