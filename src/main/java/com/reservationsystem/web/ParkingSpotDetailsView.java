package com.reservationsystem.web;

public class ParkingSpotDetailsView {

    private Integer parking_id;
    private Integer width;
    private Integer length;
    private Integer parking_level_id;
    private Integer parking_level;
    private Integer building_id;
    private String building_address;

    public ParkingSpotDetailsView(Integer parking_id, Integer width, Integer length, Integer parking_level_id, Integer parking_level, Integer building_id, String building_address) {
        this.parking_id = parking_id;
        this.width = width;
        this.length = length;
        this.parking_level_id = parking_level_id;
        this.parking_level = parking_level;
        this.building_id = building_id;
        this.building_address = building_address;
    }

    public Integer getParking_id() {
        return parking_id;
    }

    public void setParking_id(Integer parking_id) {
        this.parking_id = parking_id;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getParking_level_id() {
        return parking_level_id;
    }

    public void setParking_level_id(Integer parking_level_id) {
        this.parking_level_id = parking_level_id;
    }

    public Integer getParking_level() {
        return parking_level;
    }

    public void setParking_level(Integer parking_level) {
        this.parking_level = parking_level;
    }

    public Integer getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(Integer building_id) {
        this.building_id = building_id;
    }

    public String getBuilding_address() {
        return building_address;
    }

    public void setBuilding_address(String building_address) {
        this.building_address = building_address;
    }
}
