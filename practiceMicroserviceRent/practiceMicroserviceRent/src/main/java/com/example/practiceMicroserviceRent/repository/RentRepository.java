package com.example.practiceMicroserviceRent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rent.Rent;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {
}
