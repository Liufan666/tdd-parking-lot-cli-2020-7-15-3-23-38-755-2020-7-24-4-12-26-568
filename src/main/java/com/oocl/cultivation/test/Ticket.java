package com.oocl.cultivation.test;

public class Ticket {
    private String number;
    private ParkingBoy parkingBoy;
    private boolean isUsed;

    public Ticket(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public ParkingBoy getParkingBoy() {
        return parkingBoy;
    }
    public void useTicket(){
        this.isUsed = true;
    }

    public boolean getIsUsed() {
        return isUsed;
    }
}
