package io.java.exercise.systems.parking.lot.api.service;

import io.java.exercise.systems.parking.lot.api.internal.ParkingChargeStrategy;
import io.java.exercise.systems.parking.lot.domain.Ticket;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.exception.InvalidVehicleNumberException;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;

import java.math.BigDecimal;

public interface ParkingService {

    Ticket park(Vehicle vehicle) throws ParkingFullException;

    BigDecimal unPark(Ticket ticket, ParkingChargeStrategy parkingChargeStrategy) throws InvalidVehicleNumberException;

}
