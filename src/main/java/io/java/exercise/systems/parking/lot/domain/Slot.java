package io.java.exercise.systems.parking.lot.domain;

public class Slot {

    private final Long slotId;
    private Boolean isEmpty;
    private Vehicle vehicle;

    public Slot(Long slotId) {
        this.slotId = slotId;
        isEmpty = true;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "slotId=" + slotId +
                ", isEmpty=" + isEmpty +
                ", vehicle=" + vehicle +
                '}';
    }

    public Long getSlotId() {
        return slotId;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void blockSlot(Vehicle vehicle) {
        this.vehicle = vehicle;
        isEmpty = false;
    }

    public void unBlockSlot() {
        vehicle = null;
        isEmpty = true;
    }
}
