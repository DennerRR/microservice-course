package com.udemyCourse.hrworker.resources;


import com.udemyCourse.hrworker.entities.Worker;
import com.udemyCourse.hrworker.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository repository;


    @GetMapping()
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();

        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = repository.findById(id).get();

        return ResponseEntity.ok(worker);
    }
}
