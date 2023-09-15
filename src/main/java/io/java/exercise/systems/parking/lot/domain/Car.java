package io.java.exercise.systems.parking.lot.domain;

public class Car extends Vehicle {

    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleSize.SMALL);
    }

    @Override
    public Boolean wouldFirInSlot(Slot slot) {
        return null;
    }
}
