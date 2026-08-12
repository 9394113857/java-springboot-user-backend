package com.javauserbackend;

import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository to provide CRUD operations for the User entity.
public interface UserRepository extends JpaRepository<User, Long> {
}
