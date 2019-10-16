package com.hcl.booklib.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.booklib.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	Optional<Book> findByBookId(int bookId);

	
}
