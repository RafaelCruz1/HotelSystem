package model.entities;

import model.Exception.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer roomNumber;
    private Date checkin;
    private Date checkout;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, Date checkin, Date checkout) throws DomainException {
        if (!checkout.after(checkin)){
            throw new DomainException("O Check-out não pode ser antes do Check-in.");
        }
        this.roomNumber = roomNumber;
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duration(){
        long dif = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }
    public void updateDates(Date checkin, Date checkout) throws DomainException {
        Date now = new Date();
        if (checkin.before(now) || checkout.before(now)){
           throw new DomainException("Data invalida.");
        }

        this.checkin = checkin;
        this.checkout = checkout;

    }

    @Override

    public String toString(){
        return "Numero do quarto: "
                + roomNumber
                + ", Check-in: "
                + sdf.format(checkin)
                + ", Check-out: "
                + sdf.format(checkout)
                + ", "
                + duration()
                + " nights.";
    }
}
