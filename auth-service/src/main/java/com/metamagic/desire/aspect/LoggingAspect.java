package com.metamagic.desire.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {
	
	private static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(* com.metamagic.desire..*.*(..))")
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable{
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object retVal = joinPoint.proceed();

		stopWatch.stop();

		StringBuffer logMessage = new StringBuffer();
		logMessage.append("executed ");
		logMessage.append(joinPoint.getTarget().getClass().getName());
		logMessage.append(".");
		logMessage.append(joinPoint.getSignature().getName());
		logMessage.append("(");
		// append args
		Object[] args = joinPoint.getArgs();
		for (int i = 0; i < args.length; i++) {
			logMessage.append(args[i]).append(",");
		}
		if (args.length > 0) {
			logMessage.deleteCharAt(logMessage.length() - 1);
		}

		logMessage.append(")");
		logMessage.append(" in : ");
		logMessage.append(stopWatch.getTotalTimeMillis());
		logMessage.append(" ms");
		logger.debug(logMessage.toString());
		return retVal;
	}

}
