package com.oocl.cultivation.test;

import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private int capacity;
    private HashMap<Ticket,Car> parkingRoom = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = 10;
    }

    public void addParkingRoom(Ticket ticket,Car car) {
        this.parkingRoom.put(ticket,car);
    }

    public int getCapacity() {
        return capacity;
    }

    public HashMap<Ticket, Car> getParkingRoom() {
        return parkingRoom;
    }

    public boolean isContainCar(Car car1) {
        return parkingRoom.containsValue(car1);
    }

    public boolean isNoPosition() {
        return parkingRoom.size()>=capacity;
    }

    public int getEmptyPosition() {
        return capacity - parkingRoom.size();
    }
}
