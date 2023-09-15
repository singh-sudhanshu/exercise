package io.java.exercise.systems.parking.lot.api.service;

import io.java.exercise.systems.parking.lot.domain.Slot;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.domain.VehicleSize;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;
import io.java.exercise.systems.parking.lot.repository.SlotRepository;

public class SlotServiceImpl implements SlotService {

    private final SlotRepository slotRepository;

    public SlotServiceImpl(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public void buildSlots(VehicleSize vehicleSize, Integer numberOfSlots) {
        slotRepository.buildSlots(vehicleSize, numberOfSlots);
    }

    @Override
    public Slot getSlotById(Long id, VehicleSize vehicleSize) {
        return slotRepository.getSlotById(id, vehicleSize);
    }

    @Override
    public Slot nextAvailableSlotForGivenVehicle(Vehicle vehicle) throws ParkingFullException {
        return slotRepository.getSlotByVehicle(vehicle);
    }
}
