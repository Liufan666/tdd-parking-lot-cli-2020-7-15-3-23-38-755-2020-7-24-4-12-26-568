package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLots = new ArrayList<>();
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
        if (parkingLot.getCapacity()>=parkingLot.getParkingRoom().size()){
            return null;
        }
        Ticket ticket = new Ticket();
        ticket.setParkingBoy(this);
        parkingLot.addParkingRoom(ticket,car);
        return ticket;

    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }
    public void addParkingLots(ParkingLot parkingLot){
        this.parkingLots.add(parkingLot);

    }
}
