package com.bank.servicedb;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.bank.entity.BootcoinSolicitation;
import com.bank.repository.BootcoinSolicitationRepository;
import com.bank.service.IBootcoinSolicitationService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class BootcoinSolicitationServicedb implements IBootcoinSolicitationService {

	private final KafkaTemplate<String, BootcoinSolicitation> kafkaTemplate;

	private final BootcoinSolicitationRepository repoBootcoinSolicitation;

	@Override
	public Mono<BootcoinSolicitation> create(BootcoinSolicitation bootcoinSolicitation) {
		// TODO Auto-generated method stub
		return repoBootcoinSolicitation.save(bootcoinSolicitation);
	}

	@Override
	public Flux<BootcoinSolicitation> findAll() {
		// TODO Auto-generated method stub
		return repoBootcoinSolicitation.findAll();
	}

	@Override
	public Mono<BootcoinSolicitation> findById(String id) {
		// TODO Auto-generated method stub
		return repoBootcoinSolicitation.findById(id);
	}

	@Override
	public Mono<BootcoinSolicitation> update(String id, BootcoinSolicitation bootcoinSolicitation) {
		// TODO Auto-generated method stub
		return repoBootcoinSolicitation.findById(id).flatMap(e -> {
			bootcoinSolicitation.setId(e.getId());
			return repoBootcoinSolicitation.save(bootcoinSolicitation);
		});
	}

	/**
	 * Primer paso
	 */
	@Override
	public Mono<BootcoinSolicitation> confirmsolicitation(BootcoinSolicitation bootcoinSolicitation) {
		// TODO Auto-generated method stub
		if(bootcoinSolicitation.getEstatus()==true) {
		
			kafkaTemplate.send("bootcoinsolicitation", bootcoinSolicitation);
			
		}
		return null;
	}

}
