package com.example.challengefragmentsrecyclerview;

public class Car
{
    private String owner;
    private String ownerTel;

    private int maker;
    private String model;

    public Car(String owner, String ownerTel, int maker, String model)
    {
        this.owner = owner;
        this.ownerTel = ownerTel;

        this.maker = maker;
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel;
    }

    public int getMaker() {
        return maker;
    }

    public void setMaker(int maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
