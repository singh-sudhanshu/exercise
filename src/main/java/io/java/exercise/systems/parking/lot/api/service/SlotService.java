package io.java.exercise.systems.parking.lot.api.service;

import io.java.exercise.systems.parking.lot.domain.Slot;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.domain.VehicleSize;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;

public interface SlotService {

    void buildSlots(VehicleSize vehicleSize, Integer numberOfSlots);

    Slot getSlotById(Long id, VehicleSize vehicleSize);

    Slot nextAvailableSlotForGivenVehicle(Vehicle vehicle) throws ParkingFullException;
}
