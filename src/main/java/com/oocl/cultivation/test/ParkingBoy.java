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



                return parkingLots.get(index).getParkingRoom().remove(ticket);
            }

        }
        System.out.print("Unrecognized parking ticket.\n");
        return null;

    }

    public Ticket parking(Car car, ParkingLot parkingLot) {
        if (parkingLot.getCapacity()<=parkingLot.getParkingRoom().size()){
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket();

        parkingLot.addParkingRoom(ticket,car);
        return ticket;

    }

    public void addParkingLots(ParkingLot parkingLot){
        this.parkingLots.add(parkingLot);

    }
    public boolean isRecognized(Ticket ticket,ParkingLot parkingLot){
        return parkingLot.getParkingRoom().containsKey(ticket);
    }
}
