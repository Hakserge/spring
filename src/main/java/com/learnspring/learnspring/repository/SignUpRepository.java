package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SignUpRepository extends JpaRepository<SignUp ,String> {
}
