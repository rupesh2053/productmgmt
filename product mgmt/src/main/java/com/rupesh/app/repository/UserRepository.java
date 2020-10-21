package com.rupesh.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rupesh.app.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public abstract User findByUsername(String username);
}
