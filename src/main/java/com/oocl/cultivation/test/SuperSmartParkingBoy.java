package com.oocl.cultivation.test;

public class SuperSmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parking(Car car) {
        ParkingLot parkingLot = parkingLots.get(0);
        for(int index=0;index<parkingLots.size();index++){
            if((parkingLot.getEmptyRate())
                    <(parkingLots.get(index).getEmptyRate())){
                parkingLot = parkingLots.get(index);
            }

        }

        if(parkingLot.isNoPosition()){
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket(car.getNumber());
        ticket.setParkingBoy(this);
        parkingLot.addParkingRoom(ticket,car);
        return ticket;

    }
}
