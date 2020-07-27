package com.oocl.cultivation.test;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parking(Car car) {
        ParkingLot parkingLot = parkingLots.get(0);
        for(int index=0;index<parkingLots.size();index++){//todo
            if((parkingLot.getEmptyPosition())
                        <(parkingLots.get(index).getEmptyPosition())){
                parkingLot = parkingLots.get(index);
            }

        }
        if(parkingLot.isNoPosition()){
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket(car.getNumber());
        parkingLot.addParkingRoom(ticket,car);
        return ticket;

    }
}
