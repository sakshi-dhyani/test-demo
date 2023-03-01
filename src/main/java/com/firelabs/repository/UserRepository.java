package com.firelabs.repository;

import org.springframework.data.repository.CrudRepository;

import com.firelabs.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByEmail(String email);

}
