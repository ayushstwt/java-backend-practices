package com.ayshriv.bootrestproj12miniprojectapidevelopment.repository;

import com.ayshriv.bootrestproj12miniprojectapidevelopment.entity.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITouristRepository  extends JpaRepository<Tourist, Integer> {

    @Query("from Tourist where budget between ?1 and ?2")
    List<Tourist> showAllTouristByBudget(Double startBudget, Double endBudget);

    @Query("from Tourist where tName= :name")
    List<Tourist> findAllTouristsByName(@Param("name") String name);

    @Query("delete from Tourist where packageType=:packageName")
    void deleteTouristByPackageType(@Param("packageName") String packageName);
}
