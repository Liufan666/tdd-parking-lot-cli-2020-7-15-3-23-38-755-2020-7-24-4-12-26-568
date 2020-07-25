package com.oocl.cultivation.test;

public class ParkingBoy {
    public Ticket parking(Car car) {
        Ticket ticket = new Ticket(car.getNumber());
        ticket.setParkingBoy(this);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(ticket.getParkingBoy()!=this){
            return null;
        }
        return new Car(ticket.getNumber());

    }
}
