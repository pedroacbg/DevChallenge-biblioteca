package com.pedroanjos.biblioteca.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedroanjos.biblioteca.domain.dto.LibraryDTO;
import com.pedroanjos.biblioteca.services.LibraryService;

@RestController
@RequestMapping(value = "/biblioteca")
public class LibraryResource {
	
	@Autowired
	private LibraryService service;

	
	@GetMapping(value = "/obras")
	public ResponseEntity<Page<LibraryDTO>> findAll(
			@RequestParam(value = "authorId", defaultValue = "0") Long authorId,
			@RequestParam(value = "name", defaultValue = "") String name, Pageable pageable){
		Page<LibraryDTO> list = service.findAllPaged(authorId, name.trim(), pageable);
		return ResponseEntity.ok().body(list);
	}
}
