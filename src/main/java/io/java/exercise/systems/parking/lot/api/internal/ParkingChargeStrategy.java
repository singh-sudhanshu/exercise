package io.java.exercise.systems.parking.lot.api.internal;

import java.math.BigDecimal;

public interface ParkingChargeStrategy {

    BigDecimal calculateCharge(Integer hours);
}
