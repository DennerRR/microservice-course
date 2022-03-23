package com.udemycourse.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemycourse.hrpayroll.entities.Worker;




@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WokerFeignClient {
	
	 @GetMapping("/{id}")
	 ResponseEntity<Worker> findById(@PathVariable Long id);

}
