package com.sparta.spring2.repository;

import com.sparta.spring2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
