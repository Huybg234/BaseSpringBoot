package com.example.kidcall.cmmn.base;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class BaseCrudController<T, ID> {
    private BaseCrudService<T, ID> service;

    protected void setService(BaseCrudService<T, ID> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> select() {
        return service.select();
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody T entity) {
        return service.save(entity);
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<?> delete(@PathVariable(value = "seq") ID seq) {
        return service.delete(seq);
    }

    @GetMapping("/{seq}")
    public ResponseEntity<?> find(@PathVariable(value = "seq") ID seq) {
        return service.find(seq);
    }
}
