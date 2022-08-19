package com.udemyCourse.hrworker.resources;

import com.udemyCourse.hrworker.dtos.WorkerDto;
import com.udemyCourse.hrworker.entities.Worker;
import com.udemyCourse.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@CrossOrigin
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {


        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        logger.info("PORT = " + env.getProperty("local.server.port"));

        Worker obj = repository.findById(id).get();
        return ResponseEntity.ok(obj);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Worker> saveWorker(@RequestBody WorkerDto dto){
        Worker worker = new Worker();
        worker.setName(dto.getName());
        worker.setDailyIncome(dto.getDailyIncome());
        worker.setCargo(dto.getCargo());
        worker.setEmpresa(dto.getEmpresa());
        worker.setCnpj(dto.getCnpj());
        worker.setEmail(dto.getEmail());
        worker.setPrimeiroNome(dto.getPrimeiroNome());
        worker.setUltimoNome((dto.getUltimoNome()));
        worker.setCidade(dto.getCidade());
        worker.setPais(dto.getPais());
        worker.setCep(dto.getCep());
        repository.save(worker);

        return ResponseEntity.ok(worker);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Worker> deleteWorker(@PathVariable Long id){
        Worker worker = findById(id).getBody();
        repository.deleteById(id);
        return ResponseEntity.ok(worker);
    }
}