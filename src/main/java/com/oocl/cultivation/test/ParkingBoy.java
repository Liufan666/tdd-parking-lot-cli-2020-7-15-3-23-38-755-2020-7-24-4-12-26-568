package com.oocl.cultivation.test;

public class ParkingBoy {
    public Ticket parking(Car car) {
        Ticket ticket = new Ticket(car.getNumber());
        ticket.setParkingBoy(this);
        return ticket;
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            return null;
        }
        if(ticket.getParkingBoy()!=this){
            return null;
        }
        if (ticket.getIsUsed()){
            return null;
        }
        ticket.useTicket();
        return new Car(ticket.getNumber());

    }

    public Ticket parking(Car car, ParkingLot parkingLot) {
        return null;
    }


}
