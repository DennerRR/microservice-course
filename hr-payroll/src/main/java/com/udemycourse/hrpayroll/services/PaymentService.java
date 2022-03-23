package com.udemycourse.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemycourse.hrpayroll.entities.Payment;
import com.udemycourse.hrpayroll.entities.Worker;
import com.udemycourse.hrpayroll.feignclients.WokerFeignClient;


@Service
public class PaymentService {

	

	@Autowired
	private WokerFeignClient workerFeignClient;
	
	
    public Payment getPayment(long workerId, int days){
        
    	Worker worker = workerFeignClient.findById(workerId).getBody();
    	
    	return new Payment(worker.getName(),worker.getDailyIncome(), days);
    }
}
