package it.triexercise.API_Custom_Queries_01.repository;

import it.triexercise.API_Custom_Queries_01.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FlightRepository extends JpaRepository<Flight, Integer> {}
