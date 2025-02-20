package com.ayshriv.springrestproj3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Customer {
    private Integer cno;
    private String cname;
    private String cAddress;
    private Float billAmt;
    private String[] nickNames;
    private List<String> friends;
    private Set<Long> phoneNumbers;
    private Map<String,Integer> idDetails;
    //HAS-A RELATION
    private Company company;
    private LocalDateTime dob;
    private Boolean isIndian;

    public Customer(Integer cno, String cname, String cAddress, Float billAmt, String[] nickNames, List<String> friends, Set<Long> phoneNumbers, Map<String, Integer> idDetails, Company company, LocalDateTime dob, Boolean isIndian) {
        this.cno = cno;
        this.cname = cname;
        this.cAddress = cAddress;
        this.billAmt = billAmt;
        this.nickNames = nickNames;
        this.friends = friends;
        this.phoneNumbers = phoneNumbers;
        this.idDetails = idDetails;
        this.company = company;
        this.dob = dob;
        this.isIndian = isIndian;
    }

    public String[] getNickNames() {
        return nickNames;
    }

    public void setNickNames(String[] nickNames) {
        this.nickNames = nickNames;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    public Set<Long> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Map<String, Integer> getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(Map<String, Integer> idDetails) {
        this.idDetails = idDetails;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public Boolean getIndian() {
        return isIndian;
    }

    public void setIndian(Boolean indian) {
        isIndian = indian;
    }

    public Customer() {
    }

    public Customer(Integer cno, String cname, String cAddress, Float billAmt) {

        this.cno = cno;
        this.cname = cname;
        this.cAddress = cAddress;
        this.billAmt = billAmt;
    }

    public Integer getCno() {
        return cno;
    }

    public void setCno(Integer cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public Float getBillAmt() {
        return billAmt;
    }

    public void setBillAmt(Float billAmt) {
        this.billAmt = billAmt;
    }
}
