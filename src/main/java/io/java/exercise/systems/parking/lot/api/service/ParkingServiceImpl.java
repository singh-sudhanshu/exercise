package io.java.exercise.systems.parking.lot.api.service;

import io.java.exercise.systems.parking.lot.api.internal.ParkingChargeStrategy;
import io.java.exercise.systems.parking.lot.domain.Slot;
import io.java.exercise.systems.parking.lot.domain.Ticket;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.exception.InvalidVehicleNumberException;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * This will be a singleton class
 */
public class ParkingServiceImpl implements ParkingService {

    private final SlotService service;

    public ParkingServiceImpl(SlotService service) {
        this.service = service;
    }

    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        /*
          Step 1. Call slotService to get the available slot for given vehicle.
          If not slot available then throw an exception
          If slot is available then block the slot and return the ticket
         */
        Slot slot = service.nextAvailableSlotForGivenVehicle(vehicle);
        slot.blockSlot(vehicle);
        return new Ticket.Builder(slot.getSlotId(), vehicle.getVehicleNumber())
                .parkStartTime(LocalDateTime.now())
                .vehicleSize(vehicle.getVehicleSize())
                .build();
    }

    @Override
    public BigDecimal unPark(Ticket ticket, ParkingChargeStrategy parkingChargeStrategy) throws InvalidVehicleNumberException {
        Slot slot = service.getSlotById(ticket.getSlotId(), ticket.getVehicleSize());
        slot.unBlockSlot();
        long hour = ChronoUnit.HOURS.between(ticket.getParkStartTime(), LocalDateTime.now());
        return parkingChargeStrategy.calculateCharge((int) hour);
    }
}
