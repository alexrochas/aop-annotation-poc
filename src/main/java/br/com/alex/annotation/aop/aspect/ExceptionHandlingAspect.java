package br.com.alex.annotation.aop.aspect;

import br.com.alex.annotation.aop.exception.ErrorBuilder;
import br.com.alex.annotation.aop.annotation.ExpectedExceptionDecorator;
import br.com.alex.annotation.aop.exception.ExpectedException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionHandlingAspect {

  @Around(value="@annotation(ExpectedExceptionDecorator)", argNames="decorator")
  public Object expectedExceptionDecorator(ProceedingJoinPoint joinPoint) throws Throwable {
    try {
      return joinPoint.proceed();
    } catch(Exception e) {
      MethodSignature signature = (MethodSignature) joinPoint.getSignature();
      Method method = signature.getMethod();

      ExpectedExceptionDecorator decorator = method.getAnnotation(ExpectedExceptionDecorator.class);

      Optional<Class> error = Arrays.stream(decorator.forClass())
              .filter((Class clazz) -> clazz.isInstance(e))
              .findFirst();

      if(error.isPresent()) {
        throw new ExpectedException(e, new ErrorBuilder(decorator.value()).build());
      }
      throw e;
    }
  }

}
