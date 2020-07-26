package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {
    @Test
    void should_return_true_when_iscontaincar_after_parking_in_two_parkinglot_given_four_car_and_supersmartparkingboy() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        ParkingLot parkingLotA = new ParkingLot(3);
        ParkingLot parkingLotB = new ParkingLot(6);
        superSmartParkingBoy.addParkingLots(parkingLotA);
        superSmartParkingBoy.addParkingLots(parkingLotB);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();

        //when
        superSmartParkingBoy.parking(car1);
        superSmartParkingBoy.parking(car2);
        superSmartParkingBoy.parking(car3);
        superSmartParkingBoy.parking(car4);
        boolean isCar1InA = parkingLotA.isContainCar(car1);
        boolean isCar2InB = parkingLotB.isContainCar(car2);
        boolean isCar3InB = parkingLotB.isContainCar(car3);
        boolean isCar4InA = parkingLotA.isContainCar(car4);

        //then
        assertEquals(true,isCar1InA);
        assertEquals(true,isCar2InB);
        assertEquals(true,isCar3InB);
        assertEquals(true,isCar4InA);
    }
}
