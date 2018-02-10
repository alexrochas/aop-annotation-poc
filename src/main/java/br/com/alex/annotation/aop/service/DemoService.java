package br.com.alex.annotation.aop.service;

import br.com.alex.annotation.aop.annotation.ExpectedExceptionDecorator;
import br.com.alex.annotation.aop.entity.DemoEntity;
import org.springframework.stereotype.Component;

@Component
public class DemoService {

  @ExpectedExceptionDecorator(value = "Throwing expected exception!", forClass = { IllegalStateException.class, IllegalArgumentException.class })
  public DemoEntity couldThrowException() {
    throw new IllegalArgumentException();
  }

  @ExpectedExceptionDecorator(value = "Does't matter.", forClass = { IllegalStateException.class })
  public DemoEntity notThrowExpectedException() {
    throw new IllegalArgumentException();
  }
}
