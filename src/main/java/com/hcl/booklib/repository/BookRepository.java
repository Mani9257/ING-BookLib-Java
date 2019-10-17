
package com.hcl.booklib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.booklib.entity.Book;



@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
}