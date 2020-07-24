package com.oocl.cultivation.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {
    @Test
    void should_return_one_ticket_123456_when_parking_car_given_one_car_123456() {
        //given
        Car car = new Car("123456");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket = parkingBoy.parking(car);
        //then
        assertEquals("123456",ticket.getNumber());
    }

}
