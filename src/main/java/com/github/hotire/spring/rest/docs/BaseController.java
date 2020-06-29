package com.github.hotire.spring.rest.docs;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/base")
public class BaseController {

    @GetMapping
    public ResponseEntity<List<Entity>> entities() {
        return ResponseEntity.ok(List.of(Entity.builder().name("hotire").build()));
    }

    @GetMapping("/{name}")
    public ResponseEntity<Entity> entity(final String name) {
        return ResponseEntity.ok(Entity.builder().name(name).build());
    }
}
