package com.ayshriv.bootrestproj12miniprojectapidevelopment.service;

import com.ayshriv.bootrestproj12miniprojectapidevelopment.entity.Tourist;
import com.ayshriv.bootrestproj12miniprojectapidevelopment.error.TouristNotFoundException;

import java.util.List;

public interface ITouristManagementService {
    String registerTourist(Tourist tourist);
    List<Tourist> showAllTourist();
    List<Tourist> showTouristByBudget(Double startBudget, Double endBudget);
    Tourist showTouristById(Integer id) throws TouristNotFoundException;
    String updateTourist(Tourist tourist)throws TouristNotFoundException;
    String deleteTourist(Integer id)throws TouristNotFoundException;
    List<Tourist> getTouristByName(String name);
    String updateTouristBudgetById(Integer id, Double hikePercentage)throws TouristNotFoundException;
    String removeTouristByBudgetRange(Double start, Double end);
    String removeTouristsByPackageName(String packageName);
}
