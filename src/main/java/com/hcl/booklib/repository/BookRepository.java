package com.hcl.booklib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.booklib.entity.Book;

/**
 * @author Abhishek
 *
 */
public interface BookRepository extends JpaRepository<Book, Integer> {

	/**
	 * @param book_name
	 * @return
	 */
	List<Book> findByBookNameStartsWith(String book_name);
	
	
	/**
	 * @param categoryId
	 * @return
	 */
	List<Book> findBookByCategoryId(Integer categoryId);
	
//	List<Book> findBookByCategoryId(Integer categoryId);
	
	
	

}
