package io.java.exercise.systems.parking.lot.repository;

import io.java.exercise.systems.parking.lot.domain.Vehicle;

public interface ParkingRepository {

    void park(Vehicle vehicle);
}
