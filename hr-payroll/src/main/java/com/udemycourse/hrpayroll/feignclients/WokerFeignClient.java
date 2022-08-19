package com.udemycourse.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemycourse.hrpayroll.entities.Worker;

@Component
@FeignClient(name = "worker", url = "localhost:8080", path = "worker/workers")
public interface WokerFeignClient {
	
	 @GetMapping("/{id}")
	 ResponseEntity<Worker> findById(@PathVariable Long id);

}
