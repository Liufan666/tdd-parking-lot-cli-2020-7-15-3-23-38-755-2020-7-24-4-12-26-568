package com.oocl.cultivation.test;

public class Ticket {
    private String number;
    private ParkingBoy parkingBoy;

    public Ticket(String number) {
        this.number = number;
    }

    public Ticket() {
    }

    public String getNumber() {
        return number;
    }

    public void setParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }


}
