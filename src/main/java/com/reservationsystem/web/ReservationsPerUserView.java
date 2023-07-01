package com.reservationsystem.web;

public class ReservationsPerUserView {

    private String firstname;
    private String lastname;
    private Integer userid;

    private Integer total_reservations;

    public ReservationsPerUserView(String first_name, String last_name, Integer userid, Integer total_reservations) {
        this.firstname = first_name;
        this.lastname = last_name;
        this.userid = userid;
        this.total_reservations = total_reservations;
    }

    public String getFirst_name() {
        return firstname;
    }

    public void setFirst_name(String first_name) {
        this.firstname = first_name;
    }

    public String getLast_name() {
        return lastname;
    }

    public void setLast_name(String last_name) {
        this.lastname = last_name;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTotal_reservations() {
        return total_reservations;
    }

    public void setTotal_reservations(Integer total_reservations) {
        this.total_reservations = total_reservations;
    }
}
