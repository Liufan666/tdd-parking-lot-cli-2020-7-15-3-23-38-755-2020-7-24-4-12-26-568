package com.oocl.cultivation.test;

public class ParkingBoy {
    public Ticket parking(Car car) {
        return new Ticket(car.getNumber());
    }

    public Car fetch(Ticket ticket) {
        return new Car(ticket.getNumber());
    }
}
