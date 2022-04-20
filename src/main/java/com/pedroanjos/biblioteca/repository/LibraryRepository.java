package com.pedroanjos.biblioteca.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pedroanjos.biblioteca.domain.Authors;
import com.pedroanjos.biblioteca.domain.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {
	
	@Query("SELECT DISTINCT obj FROM Library obj INNER JOIN obj.authors auths "
			+ "WHERE (COALESCE(:authors) IS NULL OR auths IN :authors) AND "
			+ "(LOWER(obj.title) LIKE LOWER(CONCAT ('%', :title, '%')) )")
	Page<Library> find(List<Authors> authors, String title, Pageable pageable);
	
	@Query("SELECT obj FROM Library obj JOIN FETCH obj.authors "
			+ "WHERE obj IN :libraries")
	List<Library> findLibrariesWithAuthors(List<Library> libraries);

}
