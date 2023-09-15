package io.java.exercise.systems.parking.lot.repository;

import io.java.exercise.systems.parking.lot.domain.Slot;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.domain.VehicleSize;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SlotRepositoryImpl implements SlotRepository {

    List<Slot> slotsForSmallVehicles = new ArrayList<>();
    List<Slot> slotsForMediumVehicles = new ArrayList<>();
    List<Slot> slotsForLargeVehicles = new ArrayList<>();

//    @Override
//    public void occupySlot(Vehicle vehicle) throws ParkingFullException {
//        var slot = getSlot(vehicle);
//        if (vehicle.getVehicleSize() == VehicleSize.SMALL) {
//            slot.blockSlot(vehicle);
//            slotsForSmallVehicles.add(slot);
//        }
//    }

    @Override
    public Slot getSlotById(Long id, VehicleSize vehicleSize) {
        if (vehicleSize.equals(VehicleSize.SMALL)) {
            for (Slot slot : slotsForSmallVehicles) {
                if (slot.getSlotId().equals(id)) {
                    return slot;
                }
            }
        }
        if (vehicleSize.equals(VehicleSize.MEDIUM)) {
            for (Slot slot : slotsForMediumVehicles) {
                if (slot.getSlotId().equals(id)) {
                    return slot;
                }
            }
        }
        if (vehicleSize.equals(VehicleSize.LARGE)) {
            for (Slot slot : slotsForLargeVehicles) {
                if (slot.getSlotId().equals(id)) {
                    return slot;
                }
            }
        }
        return null;
    }

    @Override
    public void buildSlots(VehicleSize vehicleSize, Integer numberOfSlots) {
        for (int i = 1; i <= numberOfSlots; i++) {
            if (VehicleSize.SMALL == vehicleSize) {
                Slot slot = new Slot(new Random().nextLong());
                this.slotsForSmallVehicles.add(slot);
            }
            if (vehicleSize == VehicleSize.MEDIUM) {
                Slot slot = new Slot(new Random().nextLong());
                this.slotsForMediumVehicles.add(slot);
            }
            if (vehicleSize.equals(VehicleSize.LARGE)) {
                Slot slot = new Slot(new Random().nextLong());
                this.slotsForLargeVehicles.add(slot);
            }
        }
    }

    @Override
    public Slot getSlotByVehicle(Vehicle vehicle) throws ParkingFullException {
        return getSlot(vehicle);
    }

    private Slot getSlot(Vehicle vehicle) throws ParkingFullException {
        if (vehicle.getVehicleSize() == VehicleSize.SMALL) {
            for (Slot slot : this.slotsForSmallVehicles) {
                if (slot.getEmpty()) {
                    return slot;
                }
            }
        }
        if (vehicle.getVehicleSize().equals(VehicleSize.MEDIUM)) {
            for (Slot slot : this.slotsForMediumVehicles) {
                if (slot.getEmpty()) {
                    return slot;
                }
            }
        }
        if (vehicle.getVehicleSize().equals(VehicleSize.LARGE)) {
            for (Slot slot : this.slotsForLargeVehicles) {
                if (slot.getEmpty()) {
                    return slot;
                }
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }
}
