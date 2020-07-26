package com.oocl.cultivation.test;

public class SuperSmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket parking(Car car) {
        return super.parking(car);
    }
}
