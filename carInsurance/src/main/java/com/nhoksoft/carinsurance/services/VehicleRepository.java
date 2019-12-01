package com.nhoksoft.carinsurance.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nhoksoft.carinsurance.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
