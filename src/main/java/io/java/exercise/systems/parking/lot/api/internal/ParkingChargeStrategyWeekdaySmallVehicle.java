package io.java.exercise.systems.parking.lot.api.internal;

import java.math.BigDecimal;

public class ParkingChargeStrategyWeekdaySmallVehicle implements ParkingChargeStrategy {

    @Override
    public BigDecimal calculateCharge(Integer hours) {
        if (hours < 1) {
            return new BigDecimal(25);
        } else {
            return new BigDecimal(25 * hours);
        }
    }
}
