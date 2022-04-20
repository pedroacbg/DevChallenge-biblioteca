package com.pedroanjos.biblioteca.domain.dto;

import java.io.Serializable;

import com.pedroanjos.biblioteca.domain.Authors;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter 
@EqualsAndHashCode
public class AuthorsDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public AuthorsDTO(Authors entity) {
		id = entity.getId();
		name = entity.getName();
	}

}
