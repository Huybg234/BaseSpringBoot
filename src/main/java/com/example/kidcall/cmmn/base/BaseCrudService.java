package com.example.kidcall.cmmn.base;

import com.example.kidcall.payload.response.MessageResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class BaseCrudService<T, ID> {

    private JpaRepository<T, ID> repository;

    protected void setRepository(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public ResponseEntity<?> select() {
        List<T> result = repository.findAll();
        return ResponseEntity.ok(new Response().setDataList(result).setMessage("Successfully!"));
    }

    public ResponseEntity<?> save(T entity) {
        try {
            T saveEntity = repository.save(entity);
            return ResponseEntity.ok(new Response().setData(saveEntity).setMessage("Saved!"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(new MessageResponse("Can't not save entity!"));
        }
    }

    public ResponseEntity<?> find(ID seq) {
        Optional<T> entity = repository.findById(seq);
        if (entity.isPresent()) {
            return ResponseEntity.ok(new Response().setData(entity.get()).setMessage("Found!"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<?> delete(ID seq) {
        repository.deleteById(seq);
        return ResponseEntity.ok(new MessageResponse("Deleted!"));
    }
}
