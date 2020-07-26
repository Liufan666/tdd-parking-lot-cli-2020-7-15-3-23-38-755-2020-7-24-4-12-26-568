package com.oocl.cultivation.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParkingTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public ByteArrayOutputStream out = null;
    @BeforeEach
    public void setup(){
        System.setOut(new PrintStream(outContent));
    }
    private String systemOut(){
        return outContent.toString();
    }

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
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket1 = parkingBoy.parking(new Car("123456"));
        Ticket ticket2 = parkingBoy.parking(new Car("123457"));


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
        Ticket ticket = new Ticket("123456");
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car = parkingBoy.fetch(ticket);
        //then
        assertEquals(null,car);
    }

    @Test
    void should_return_null_when_fetch_car_given_no_ticket(){
        //given
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        //when
        Car car = parkingBoy.fetch(ticket);
        //then
        assertEquals(null,car);
    }

    @Test
    void should_return_null_when_fetch_car_given_one_used_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parking(new Car("123456"));
        //when
        Car car1 = parkingBoy.fetch(ticket);
        Car car2 = parkingBoy.fetch(ticket);
        //then
        assertEquals(null, car2);
    }

    @Test
    void should_return_null_when_parking_car_given_one_parkinglot_no_position() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        for (int index=0;index<10;index++){
            parkingBoy.parking(new Car(),parkingLot);
        }
        Ticket ticket = parkingBoy.parking(new Car(),parkingLot);

        //then
        assertEquals(null, ticket);
    }
    @Test
    void should_output_unrecognized_parking_ticket_when_fetch_car_given_one_wrong_ticket() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        parkingBoy.addParkingLots(parkingLot);
        //when
        parkingBoy.fetch(new Ticket());

        //then
        assertEquals("Unrecognized parking ticket.\n", systemOut());
    }

}
