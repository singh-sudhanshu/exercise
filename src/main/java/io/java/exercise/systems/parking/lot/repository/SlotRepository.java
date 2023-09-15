package io.java.exercise.systems.parking.lot.repository;

import io.java.exercise.systems.parking.lot.domain.Slot;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.domain.VehicleSize;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;

public interface SlotRepository {

    Slot getSlotById(Long id, VehicleSize vehicleSize);

    void buildSlots(VehicleSize vehicleSize, Integer numberOfSlots);

    Slot getSlotByVehicle(Vehicle vehicle) throws ParkingFullException;
}
