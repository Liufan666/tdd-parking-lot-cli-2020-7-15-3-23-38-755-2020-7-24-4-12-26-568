package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_return_true_when_iscontaincar_after_parking_in_two_parkinglot_given_four_car_and_smartparkingboy() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(5);
        smartParkingBoy.addParkingLots(parkingLotA);
        smartParkingBoy.addParkingLots(parkingLotB);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();

        //when
        smartParkingBoy.parking(car1);
        smartParkingBoy.parking(car2);
        smartParkingBoy.parking(car3);
        smartParkingBoy.parking(car4);
        boolean isCar1InB = parkingLotB.isContainCar(car1);
        boolean isCar2InB = parkingLotB.isContainCar(car2);
        boolean isCar3InA = parkingLotA.isContainCar(car3);
        boolean isCar4InB = parkingLotB.isContainCar(car4);

        //then
        assertEquals(true,isCar1InB);
        assertEquals(true,isCar2InB);
        assertEquals(true,isCar3InA);
        assertEquals(true,isCar4InB);
    }

}
