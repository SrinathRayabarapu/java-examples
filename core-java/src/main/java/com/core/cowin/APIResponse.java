package com.core.cowin;

import java.util.List;

public class APIResponse {
    private List<Center> centers;

    public List<Center> getCenters() {
        return centers;
    }

    public void setCenters(List<Center> centers) {
        this.centers = centers;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "centers=" + centers +
                '}';
    }
}

