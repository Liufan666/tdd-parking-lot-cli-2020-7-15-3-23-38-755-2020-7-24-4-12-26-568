package com.oocl.cultivation.test;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parking(Car car) {
        int indexOfMaxEmptyPosition = 0;
        for(int index=0;index<parkingLots.size();index++){
            if((parkingLots.get(indexOfMaxEmptyPosition).getCapacity()- parkingLots.get(indexOfMaxEmptyPosition).getParkingRoom().size())
                        <(parkingLots.get(index).getCapacity()- parkingLots.get(index).getParkingRoom().size())){
                indexOfMaxEmptyPosition = index;
            }

        }
        if(parkingLots.get(indexOfMaxEmptyPosition).isNoPosition()){
            System.out.print("Not enough position.\n");
            return null;
        }
        Ticket ticket = new Ticket(car.getNumber());
        ticket.setParkingBoy(this);
        parkingLots.get(indexOfMaxEmptyPosition).addParkingRoom(ticket,car);
        return ticket;

    }
}
