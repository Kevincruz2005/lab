package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Erepo extends JpaRepository<Employee, Long> {
    // Spring Data JPA will automatically implement this based on the name
    boolean existsByIdAndName(Long id, String name);
}
