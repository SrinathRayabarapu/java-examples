package com.hibernate.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //need to declare it in hibernate.cfg file
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;

    private String vehicleName;

    public Vehicle(){
    }

    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /**
     * @return the vehicleId
     */
    public int getVehicleId() {
        return this.vehicleId;
    }

    /**
     * @param vehicleId the vehicleId to set
     */
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    /**
     * @return the vehicleName
     */
    public String getVehicleName() {
        return this.vehicleName;
    }

    /**
     * @param vehicleName the vehicleName to set
     */
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Vehicle [vehicleId=");
        builder.append(this.vehicleId);
        builder.append(", vehicleName=");
        builder.append(this.vehicleName);
        builder.append("]");
        return builder.toString();
    }

}