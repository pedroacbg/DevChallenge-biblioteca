package com.pedroanjos.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pedroanjos.biblioteca.domain.Authors;

@Repository
public interface AuthorRepository extends JpaRepository<Authors, Long> {

}
