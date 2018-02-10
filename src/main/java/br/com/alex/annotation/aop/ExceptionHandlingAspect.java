package br.com.alex.annotation.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

  @Around("@annotation(ExpectedExceptionDecorator)")
  public Object expectedExceptionDecorator(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      return joinPoint.proceed();
    } catch(Exception e) {
      throw new ExpectedException(e, new SimpleError());
    }
  }

}
