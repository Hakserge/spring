package com.learnspring.learnspring.repository;

import com.learnspring.learnspring.models.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemesterRepository extends JpaRepository<Semester ,Long> {
}
