package com.example.demo.repository;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IGirlRepository extends JpaRepository<Girl, Integer> {
    public List<Girl> findByAge(Integer age);
}
