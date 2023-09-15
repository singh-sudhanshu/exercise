package io.java.exercise.systems.parking.lot.domain;

import java.time.LocalDateTime;

/**
 * Using the builder design pattern to build the ticket object
 */
public class Ticket {

    private final Long slotId;
    private final LocalDateTime parkStartTime;
    private final LocalDateTime parkEndTime;
    private final String vehicleNumber;
    private final VehicleSize vehicleSize;

    private Ticket(Builder builder) {
        this.slotId = builder.slotId;
        this.parkStartTime = builder.parkStartTime;
        this.parkEndTime = builder.parkEndTime;
        this.vehicleNumber = builder.vehicleNumber;
        this.vehicleSize = builder.vehicleSize;
    }

    public static class Builder {
        private final Long slotId;
        private LocalDateTime parkStartTime;
        private LocalDateTime parkEndTime;
        private final String vehicleNumber;
        private VehicleSize vehicleSize;

        public Builder(Long slotId, String vehicleNumber) {
            this.slotId = slotId;
            this.vehicleNumber = vehicleNumber;
        }

        public Builder parkStartTime(LocalDateTime parkStartTime) {
            this.parkStartTime = parkStartTime;
            return this;
        }

        public Builder parkEndTime(LocalDateTime parkEndTime) {
            this.parkEndTime = parkEndTime;
            return this;
        }

        public Builder vehicleSize(VehicleSize vehicleSize) {
            this.vehicleSize = vehicleSize;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "slotId=" + slotId +
                ", parkStartTime=" + parkStartTime +
                ", parkEndTime=" + parkEndTime +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleSize=" + vehicleSize +
                '}';
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public LocalDateTime getParkStartTime() {
        return parkStartTime;
    }

    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public Long getSlotId() {
        return slotId;
    }
}
