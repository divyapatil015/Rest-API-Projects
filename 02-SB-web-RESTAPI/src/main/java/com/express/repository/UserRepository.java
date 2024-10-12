package com.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.express.entities.User;

public interface UserRepository extends JpaRepository< User, Long> {

}
