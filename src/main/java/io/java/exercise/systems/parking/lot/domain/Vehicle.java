package io.java.exercise.systems.parking.lot.domain;

/**
 * Class to represent the vehicle to be parked.
 */
public abstract class Vehicle {

    private final String vehicleNumber;
    private final VehicleSize vehicleSize;

    public Vehicle(String vehicleNumber, VehicleSize vehicleSize) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleSize = vehicleSize;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public abstract Boolean wouldFirInSlot(Slot slot);
}
