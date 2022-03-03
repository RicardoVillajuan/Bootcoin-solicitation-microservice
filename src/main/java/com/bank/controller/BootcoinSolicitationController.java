package com.bank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.entity.BootcoinSolicitation;
import com.bank.servicedb.BootcoinSolicitationServicedb;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/solicitation")
public class BootcoinSolicitationController {
	
private final BootcoinSolicitationServicedb serviceBootcSolicitation;
	
	@PostMapping
	public Mono<BootcoinSolicitation> sendSolicitation(@RequestBody BootcoinSolicitation bootcoinSolicitation){
		
		return serviceBootcSolicitation.create(bootcoinSolicitation);
	}
	
	@GetMapping
	public Flux<BootcoinSolicitation> findAll(){
		
		return serviceBootcSolicitation.findAll();
	}
	
	@PostMapping("/confirm")
	public Mono<BootcoinSolicitation> confirmSolititation(@RequestBody BootcoinSolicitation bootcoinSolicitation){
		
		return serviceBootcSolicitation.confirmsolicitation(bootcoinSolicitation);
	}
}
