package com.express.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
public class Category {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;  
	private String name; 
}
