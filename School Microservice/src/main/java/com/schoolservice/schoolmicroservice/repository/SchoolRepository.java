package com.schoolservice.schoolmicroservice.repository;

import com.schoolservice.schoolmicroservice.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer> {
}
