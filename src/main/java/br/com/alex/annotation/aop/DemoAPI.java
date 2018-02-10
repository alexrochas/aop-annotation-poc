package br.com.alex.annotation.aop;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAPI {

  @Autowired
  public DemoService demoService;

  @GetMapping("/demo")
  public ResponseEntity<DemoEntity> getDemo() {
    return ok(demoService.couldThrowException());
  }

}
