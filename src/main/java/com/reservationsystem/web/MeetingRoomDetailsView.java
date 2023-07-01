package com.reservationsystem.web;

public class MeetingRoomDetailsView {
    private Integer meeting_room_id;
    private Integer capacity;
    private Integer floor_id;
    private Integer floor_number;
    private Integer building_id;
    private String building_address;

    public MeetingRoomDetailsView(Integer meeting_room_id, Integer capacity, Integer floor_id, Integer floor_number, Integer building_id, String building_address) {
        this.meeting_room_id = meeting_room_id;
        this.capacity = capacity;
        this.floor_id = floor_id;
        this.floor_number = floor_number;
        this.building_id = building_id;
        this.building_address = building_address;
    }

    public Integer getMeeting_room_id() {
        return meeting_room_id;
    }

    public void setMeeting_room_id(Integer meeting_room_id) {
        this.meeting_room_id = meeting_room_id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getFloor_id() {
        return floor_id;
    }

    public void setFloor_id(Integer floor_id) {
        this.floor_id = floor_id;
    }

    public Integer getFloor_number() {
        return floor_number;
    }

    public void setFloor_number(Integer floor_number) {
        this.floor_number = floor_number;
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
