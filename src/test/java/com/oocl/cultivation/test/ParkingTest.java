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

    @Test
    void should_return_one_car_123456_when_fetch_car_given_one_ticket_123456() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parking(new Car("123456"));
        //when
        Car car = parkingBoy.fetch(ticket);
        //then
        assertEquals("123456",car.getNumber());
    }

    @Test
    void should_return_two_tickets_123456_and_123457_when_parking_car_given_two_cars_123456_and_123457() {
        //given
        Car car1 = new Car("123456");
        Car car2 = new Car("123457");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Ticket ticket1 = parkingBoy.parking(car1);
        Ticket ticket2 = parkingBoy.parking(car2);

        //then
        assertEquals("123456",ticket1.getNumber());
        assertEquals("123457",ticket2.getNumber());
    }

    @Test
    void should_return_two_cars_123456_and_123457_when_parking_car_given_two_tickets_123456_and_123457(){
        //given
        Ticket ticket1 = new Ticket("123456");
        Ticket ticket2 = new Ticket("123457");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car1 = parkingBoy.fetch(ticket1);
        Car car2 = parkingBoy.fetch(ticket2);
        //then
        assertEquals("123456",car1.getNumber());
        assertEquals("123457",car2.getNumber());
    }

    @Test
    void should_return_null_when_fetch_car_given_one_wrong_ticket(){
        //given
        Ticket ticket = new Ticket("775432");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car = parkingBoy.fetch(ticket);
        //then
        assertEquals(null,car);
    }
}
