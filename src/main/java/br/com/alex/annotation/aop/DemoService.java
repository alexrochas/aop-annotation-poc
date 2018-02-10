package br.com.alex.annotation.aop;

import org.springframework.stereotype.Component;

@Component
public class DemoService {

  @ExpectedExceptionDecorator
  public DemoEntity couldThrowException() {
    throw new IllegalArgumentException();
  }

}
