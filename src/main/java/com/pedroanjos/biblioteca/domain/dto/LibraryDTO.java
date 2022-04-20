package com.pedroanjos.biblioteca.domain.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.pedroanjos.biblioteca.domain.Authors;
import com.pedroanjos.biblioteca.domain.Library;

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
public class LibraryDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String title;
	private String publisher;
	private String imgUrl;
	
	private List<AuthorsDTO> authors = new ArrayList<>();
	
	public LibraryDTO(Library entity) {
		id = entity.getId();
		title = entity.getTitle();
		publisher = entity.getPublisher();
		imgUrl = entity.getImgUrl();
	}
	
	public LibraryDTO(Library entity, Set<Authors> authors) {
		this(entity);
		authors.forEach(x -> this.authors.add(new AuthorsDTO(x)));
	}
	
	
}
