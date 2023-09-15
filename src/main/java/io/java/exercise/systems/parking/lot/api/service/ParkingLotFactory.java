package io.java.exercise.systems.parking.lot.api.service;

import io.java.exercise.systems.parking.lot.api.internal.ParkingChargeStrategyWeekdaySmallVehicle;
import io.java.exercise.systems.parking.lot.api.internal.ParkingChargeStrategyWeekendSmallVehicle;
import io.java.exercise.systems.parking.lot.domain.Ticket;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.domain.VehicleSize;
import io.java.exercise.systems.parking.lot.exception.InvalidVehicleNumberException;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;
import io.java.exercise.systems.parking.lot.repository.SlotRepositoryImpl;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.temporal.ChronoField;

/**
 * A factory class to build the parking lot
 */
public class ParkingLotFactory {

    private static ParkingLotFactory parkingLotFactory;
    private final SlotService slotService;
    private final ParkingService parkingService;

    private ParkingLotFactory() {
        slotService = new SlotServiceImpl(new SlotRepositoryImpl());
        parkingService = new ParkingServiceImpl(slotService);
    }

    public static ParkingLotFactory getParkingLot() {
        if (parkingLotFactory == null) {
            parkingLotFactory = new ParkingLotFactory();
        }
        return parkingLotFactory;
    }

    public void buildParkingLotWithSmallSizedVehicles(Integer capacity) {
        slotService.buildSlots(VehicleSize.SMALL, capacity);
    }

    public void buildParkingLotWithMediumSizedVehicles(Integer capacity) {
        slotService.buildSlots(VehicleSize.MEDIUM, capacity);
    }

    public void buildParkingLotWithLargeSizedVehicles(Integer capacity) {
        slotService.buildSlots(VehicleSize.LARGE, capacity);
    }

    public Ticket parkVehicle(Vehicle vehicle) throws ParkingFullException {
        return parkingService.park(vehicle);
    }

    public BigDecimal unParkVehicle(Ticket ticket) throws InvalidVehicleNumberException {
        if (ticket.getVehicleSize().equals(VehicleSize.SMALL)) {
            if (isWeekend(ticket)) {
                return parkingService.unPark(ticket, new ParkingChargeStrategyWeekendSmallVehicle());
            } else {
                return parkingService.unPark(ticket, new ParkingChargeStrategyWeekdaySmallVehicle());
            }
        }
        return null;
    }

    private static boolean isWeekend(Ticket ticket) {
        DayOfWeek dayOfWeek = DayOfWeek.of(ticket.getParkStartTime().get(ChronoField.DAY_OF_WEEK));
        return dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }
}
