package com.reservationsystem.web;

import java.util.Date;

public class AvailableDesksCurrDateView {

    private Integer id;
    private String floorMap;
    private String department;
    private String address;
    private String city;
    private Date date;

    public AvailableDesksCurrDateView(Integer id, String floorMap, String department, String address, String city, Date date) {
        this.id = id;
        this.floorMap = floorMap;
        this.department = department;
        this.address = address;
        this.city = city;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFloorMap() {
        return floorMap;
    }

    public void setFloorMap(String floorMap) {
        this.floorMap = floorMap;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
