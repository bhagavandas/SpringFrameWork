package com.example.demo.repository;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer>{

	
			/* JpaRepository is a JPA (Java Persistence API) specific extension of Repository. 
			 * It contains the full API of CrudRepository and PagingAndSortingRepository. 
			 * So it contains API for basic CRUD operations and 
			 * also API for pagination and sorting.
			 */
}
