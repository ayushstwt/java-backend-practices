package com.ayshriv.bootrestproj12miniprojectapidevelopment.controller;

import com.ayshriv.bootrestproj12miniprojectapidevelopment.entity.Tourist;
import com.ayshriv.bootrestproj12miniprojectapidevelopment.service.ITouristManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tourist-api")
public class TouristOperationsController {
    @Autowired
    private ITouristManagementService touristManagementService;

    @PostMapping("/save")
    public ResponseEntity<String> saveTourist(@RequestBody Tourist tourist) {
        try{
            String resultMsg=touristManagementService
                    .registerTourist(tourist);
            return new ResponseEntity<>(resultMsg, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report")
    public ResponseEntity<?> showTourist() {
        try{
            List<Tourist> tourist = touristManagementService
                    .showAllTourist();
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report/{start}/{end}")
    public ResponseEntity<?> showReportByBudget(@PathVariable Double start,@PathVariable Double end) {
        try{
            List<Tourist> tourist = touristManagementService
                    .showTouristByBudget(start,end);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<?> showReportById(@PathVariable Integer id) {
        try{
            Tourist tourist = touristManagementService
                    .showTouristById(id);
            return new ResponseEntity<>(tourist, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeTourist(@PathVariable Integer id)
    {
        try{
            String msg=touristManagementService.deleteTourist(id);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/remove/{packageType}")
    public ResponseEntity<?> removeTouristByPackageType(@PathVariable String pacakgeType)
    {
        try{
            String msg=touristManagementService.removeTouristsByPackageName(pacakgeType);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findWithName/{name}")
    public ResponseEntity<?> updateTourist(@PathVariable String name)
    {
        try{
            List<Tourist> tourists = touristManagementService.getTouristByName(name);
            return new ResponseEntity<>(tourists,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/pupdate/{id}/{percentage}")
    public ResponseEntity<?> updateTouristBudget(@PathVariable Integer id, @PathVariable Double percentage)
    {
        try{
            String msg = touristManagementService.updateTouristBudgetById(id, percentage);
            return new ResponseEntity<>(msg,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{start}/{end}")
    public ResponseEntity<?> deleteTouristByBudgetRange(@PathVariable Double start,@PathVariable Double end) {
        try{
            String msg = touristManagementService
                    .removeTouristByBudgetRange(start,end);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
