
package com.hcl.booklib.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.booklib.entity.Category;

/**
 * @author Abhishek
 *
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	/**
	 * @param CategoryId
	 * @return
	 */
	Category getByCategoryId(Integer CategoryId);

}
