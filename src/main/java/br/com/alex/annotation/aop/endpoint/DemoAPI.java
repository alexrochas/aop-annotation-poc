package br.com.alex.annotation.aop.endpoint;

import static org.springframework.http.ResponseEntity.ok;

import br.com.alex.annotation.aop.entity.DemoEntity;
import br.com.alex.annotation.aop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAPI {

  @Autowired
  public DemoService demoService;

  @GetMapping("/demo/{demoNumber}")
  public ResponseEntity<DemoEntity> getDemo(@PathVariable("demoNumber") String demoNumber) {
    switch (Integer.valueOf(demoNumber)) {
      case 1:
        return ok(demoService.couldThrowException());
      case 2:
        return ok(demoService.notThrowExpectedException());
      default:
        return ResponseEntity.notFound().build();
    }
  }

}
