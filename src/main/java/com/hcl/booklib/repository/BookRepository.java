
package com.hcl.booklib.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

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
	List<Book> findByBookNameStartsWith(String bookName);

	/**
	 * @param categoryId
	 * @return
	 */
	List<Book> findBookByCategoryId(Integer categoryId);

	Optional<Book> findByBookId(int bookId);

}
