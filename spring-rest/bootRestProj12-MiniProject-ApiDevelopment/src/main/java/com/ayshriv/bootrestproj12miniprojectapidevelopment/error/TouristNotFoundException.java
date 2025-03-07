package com.ayshriv.bootrestproj12miniprojectapidevelopment.error;

public class TouristNotFoundException extends RuntimeException {
    public TouristNotFoundException(String touristNotFound) {
        super(touristNotFound);
    }
    public TouristNotFoundException()
    {
        super();
    }
}
