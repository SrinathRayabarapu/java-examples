package com.core.cowin;

import java.util.Arrays;

public class FreeSlot {
    private String name;
    private String address;
    private String stateName;
    private String districtName;
    private String blockName;
    private String pincode;
    private int minAgeLimit;
    private String vaccine;
    private int availableCapacity;
    private int availableCapacityDose1;
    private int availableCapacityDose2;
    private String[] slots;
    private String from;
    private String to;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public int getMinAgeLimit() {
        return minAgeLimit;
    }

    public void setMinAgeLimit(int minAgeLimit) {
        this.minAgeLimit = minAgeLimit;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    public int getAvailableCapacityDose1() {
        return availableCapacityDose1;
    }

    public void setAvailableCapacityDose1(int availableCapacityDose1) {
        this.availableCapacityDose1 = availableCapacityDose1;
    }

    public int getAvailableCapacityDose2() {
        return availableCapacityDose2;
    }

    public void setAvailableCapacityDose2(int availableCapacityDose2) {
        this.availableCapacityDose2 = availableCapacityDose2;
    }

    public String[] getSlots() {
        return slots;
    }

    public void setSlots(String[] slots) {
        this.slots = slots;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "FreeSlot{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", stateName='" + stateName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", blockName='" + blockName + '\'' +
                ", pincode='" + pincode + '\'' +
                ", minAgeLimit='" + minAgeLimit + '\'' +
                ", vaccine='" + vaccine + '\'' +
                ", availableCapacity='" + availableCapacity + '\'' +
                ", availableCapacityDose1='" + availableCapacityDose1 + '\'' +
                ", availableCapacityDose2='" + availableCapacityDose2 + '\'' +
                ", slots=" + Arrays.toString(slots) +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}
