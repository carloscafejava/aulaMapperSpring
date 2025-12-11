package com.pet.miaudogpet.repositories;


import com.miaudopt.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Integer> {
}
