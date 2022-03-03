package com.bank.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "solicitation")
public class BootcoinSolicitation {
	
	@Id
	private String id;
	private String idbootcoinsubmit;
	private String idbootcoinreceive;
	private String paymentmethod;
	private Double ammount;
	private Boolean estatus=false;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime creationdate;
}
