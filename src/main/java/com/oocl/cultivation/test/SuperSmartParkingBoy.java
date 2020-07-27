package com.oocl.cultivation.test;

public class SuperSmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parking(Car car) {
        int indexOfMaxEmptyRate = 0;
        for(int index=0;index<parkingLots.size();index++){
            if((parkingLots.get(indexOfMaxEmptyRate).getEmptyRate())
                    <(parkingLots.get(index).getEmptyRate())){
                indexOfMaxEmptyRate = index;
            }

        }
        if(parkingLots.get(indexOfMaxEmptyRate).isNoPosition()){
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket(car.getNumber());
        ticket.setParkingBoy(this);
        parkingLots.get(indexOfMaxEmptyRate).addParkingRoom(ticket,car);
        return ticket;

    }
}
