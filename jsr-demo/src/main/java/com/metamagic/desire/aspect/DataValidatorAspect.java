package com.metamagic.desire.aspect;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.metamagic.desire.utils.CommonValidator;
import com.metamagic.desire.utils.DataValidator;
import com.metamagic.desire.utils.ResponseBean;

@Component
@Aspect
public class DataValidatorAspect {

	private static Logger logger = LoggerFactory.getLogger(DataValidatorAspect.class);

	@Around("execution(* com.metamagic.desire.controller.*.*(..))")
	public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		Object obj[] = joinPoint.getArgs();
		for (int i = 0; i < obj.length; i++) {
			if (obj[i] instanceof CommonValidator) {
				List<String> errors = this.hasErrors((CommonValidator) obj[i]);
				ResponseBean responseBean = new ResponseBean("Invalid data, please check errors", "Error", false, null,
						errors);
				return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.OK);
			}
		}
		Object retVal = joinPoint.proceed();
		return retVal;
	}

	public List<String> hasErrors(CommonValidator bean) {
		List<String> errors = DataValidator.validate(bean);
		return errors;
	}
}
