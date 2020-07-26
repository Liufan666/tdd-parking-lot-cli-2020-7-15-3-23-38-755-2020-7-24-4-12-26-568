package com.oocl.cultivation.test;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots = new ArrayList<>();
    public Ticket parking(Car car) {
        for(int index=0;index<parkingLots.size();index++){
            if(parkingLots.get(index).isNoPosition()){
                continue;
            }
            Ticket ticket = new Ticket(car.getNumber());
            ticket.setParkingBoy(this);
            parkingLots.get(index).addParkingRoom(ticket,car);
            return ticket;

        }
        System.out.print("Not enough position.\n");
        return null;
    }

    public Car fetch(Ticket ticket) {
        if(ticket==null){
            System.out.print("Please provide your parking ticket.\n");
            return null;
        }
        for(int index=0;index<parkingLots.size();index++){

            if(isRecognized(ticket,parkingLots.get(index))){
                ticket.useTicket();
                Car car = parkingLots.get(index).getParkingRoom().get(ticket);
                parkingLots.get(index).getParkingRoom().remove(ticket);
                return car;
            }

        }
        System.out.print("Unrecognized parking ticket.\n");
        return null;

    }
    public Car fetch(Ticket ticket ,ParkingLot parkingLot){
        if(ticket==null){
            return null;
        }
        if(!isRecognized(ticket,parkingLot)){
            return null;
        }
        ticket.useTicket();
        Car car = parkingLot.getParkingRoom().get(ticket);
        parkingLot.getParkingRoom().remove(ticket);
        return car;

    }
    public Ticket parking(Car car, ParkingLot parkingLot) {
        if (parkingLot.getCapacity()<=parkingLot.getParkingRoom().size()){
            System.out.print("Not enough position.\n");
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
    public boolean isRecognized(Ticket ticket,ParkingLot parkingLot){
        return parkingLot.getParkingRoom().containsKey(ticket);
    }
}
