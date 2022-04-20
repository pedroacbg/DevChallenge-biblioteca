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
	
}
