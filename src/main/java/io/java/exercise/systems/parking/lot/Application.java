package io.java.exercise.systems.parking.lot;

import io.java.exercise.systems.parking.lot.api.service.ParkingLotFactory;
import io.java.exercise.systems.parking.lot.domain.Car;
import io.java.exercise.systems.parking.lot.domain.Ticket;
import io.java.exercise.systems.parking.lot.domain.Vehicle;
import io.java.exercise.systems.parking.lot.exception.ParkingFullException;

import java.math.BigDecimal;

public class Application {

    public static void main(String[] args) throws ParkingFullException {

        try {
            ParkingLotFactory parkingLotFactory = ParkingLotFactory.getParkingLot();
            parkingLotFactory.buildParkingLotWithSmallSizedVehicles(2);
            parkingLotFactory.buildParkingLotWithMediumSizedVehicles(3);
            parkingLotFactory.buildParkingLotWithLargeSizedVehicles(1);

            System.out.println("*******Parking lot has been built******");
            Vehicle car = new Car("MH 12 JU 3768");
            Ticket ticket = parkingLotFactory.parkVehicle(car);
            printTicket(ticket);
            Vehicle car2 = new Car("MH 14 UT 8769");
            var ticket2 = parkingLotFactory.parkVehicle(car2);
            printTicket(ticket2);
            BigDecimal cost = parkingLotFactory.unParkVehicle(ticket);
            System.out.println("Cost is: " + cost);
        } catch (Exception ex) {
            if (ex instanceof ParkingFullException) {
                System.out.println("Parking is full");
            } else {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void printTicket(Ticket ticket) {
        System.out.println("Ticket has been issued for: " + ticket.getVehicleNumber() + " with start time: " + ticket.getParkStartTime());
    }
}
