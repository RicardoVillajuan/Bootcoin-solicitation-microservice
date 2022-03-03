package com.bank.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.bank.entity.BootcoinSolicitation;

public interface BootcoinSolicitationRepository extends ReactiveMongoRepository<BootcoinSolicitation, String>{

}
