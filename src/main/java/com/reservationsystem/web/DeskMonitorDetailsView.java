package com.reservationsystem.web;

public class DeskMonitorDetailsView {

    private Integer desk_id;
    private Integer monitor_id;
    private String manufacturer;
    private String model;
    private Integer size;
    private boolean heightadjustable;

    public DeskMonitorDetailsView(Integer desk_id, Integer monitor_id, String manufacturer, String model, Integer size, boolean heightadjustable) {
        this.desk_id = desk_id;
        this.monitor_id = monitor_id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.size = size;
        this.heightadjustable = heightadjustable;
    }

    public Integer getDesk_id() {
        return desk_id;
    }

    public void setDesk_id(Integer desk_id) {
        this.desk_id = desk_id;
    }

    public Integer getMonitor_id() {
        return monitor_id;
    }

    public void setMonitor_id(Integer monitor_id) {
        this.monitor_id = monitor_id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public boolean isHeightadjustable() {
        return heightadjustable;
    }

    public void setHeightadjustable(boolean heightadjustable) {
        this.heightadjustable = heightadjustable;
    }
}
