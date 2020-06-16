package com.project.repository;

import com.project.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
}
