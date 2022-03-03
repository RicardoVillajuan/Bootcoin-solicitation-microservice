package com.bank.service;

import com.bank.entity.BootcoinSolicitation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IBootcoinSolicitationService {
	
	Mono<BootcoinSolicitation> create (BootcoinSolicitation bootcoinSolicitation);
	
	Flux<BootcoinSolicitation> findAll();
	
	Mono<BootcoinSolicitation> findById(String id);
	
	Mono<BootcoinSolicitation> update(String id, BootcoinSolicitation bootcoinSolicitation);

	Mono<BootcoinSolicitation> confirmsolicitation(BootcoinSolicitation bootcoinSolicitation);
}
