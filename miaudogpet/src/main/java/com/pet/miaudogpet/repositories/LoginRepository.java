package com.pet.miaudogpet.repositories;
import com.miaudopt.api.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
}