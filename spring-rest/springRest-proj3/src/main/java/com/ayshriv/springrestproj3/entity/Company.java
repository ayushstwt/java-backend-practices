package com.ayshriv.springrestproj3.entity;

public class Company {
    private Integer id;
    private String name;
    private String address;
    private Integer size;

    public Company() {
    }

    public Company(Integer id, String name, String address, Integer size) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
