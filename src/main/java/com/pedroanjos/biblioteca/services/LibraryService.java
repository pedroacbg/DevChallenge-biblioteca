package com.pedroanjos.biblioteca.services;



import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pedroanjos.biblioteca.domain.Authors;
import com.pedroanjos.biblioteca.domain.Library;
import com.pedroanjos.biblioteca.domain.dto.AuthorsDTO;
import com.pedroanjos.biblioteca.domain.dto.LibraryDTO;
import com.pedroanjos.biblioteca.repository.AuthorRepository;
import com.pedroanjos.biblioteca.repository.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository repository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Transactional(readOnly = true)
	public Page<LibraryDTO> findAllPaged(Long authorId, String name, Pageable pageable){
		List<Authors> authors = (authorId == 0) ? null : Arrays.asList(authorRepository.getById(authorId));
		Page<Library> page = repository.find(authors, name, pageable);
		repository.findLibrariesWithAuthors(page.getContent());
		return page.map(x -> new LibraryDTO(x, x.getAuthors()));
	}
	
	@Transactional
	public LibraryDTO insert(LibraryDTO dto) {
		Library entity = new Library();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new LibraryDTO(entity);
	}
	
	
	private void copyDtoToEntity(LibraryDTO dto, Library entity) {
		entity.setTitle(dto.getTitle());
		entity.setPublisher(dto.getPublisher());
		entity.setImgUrl(dto.getImgUrl());
		
		
		entity.getAuthors().clear();
		for(AuthorsDTO authDto : dto.getAuthors()) {
			Authors authors = authorRepository.getById(authDto.getId());
			entity.getAuthors().add(authors);
		}
	}
	
}
