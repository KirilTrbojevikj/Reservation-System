package com.reservationsystem.web;

import java.util.Date;

public class ReservationsForFebPar {

    private Integer id;
    private Date reservationday;
    private Integer userid;

    public ReservationsForFebPar(Integer id, Date reservationday, Integer userid) {
        this.id = id;
        this.reservationday = reservationday;
        this.userid = userid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReservationday() {
        return reservationday;
    }

    public void setReservationday(Date reservationday) {
        this.reservationday = reservationday;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
