package com.example.classes;

public class House
{
    private int numWindows;
    private int numDoors;
    private String typeOfRoof;
    private String typeOfWall;

    public House()
    {
        this.numWindows = 0;
        this.numDoors = 0;
        this.typeOfRoof = null;
        this.typeOfWall = null;
    }

    public House(int numWindows, int numDoors, String typeOfRoof, String typeOfWall)
    {
        this.numWindows = numWindows;
        this.numDoors = numDoors;
        this.typeOfRoof = typeOfRoof;
        this.typeOfWall = typeOfWall;
    }

    public int getNumWindows()
    {
        return this.numWindows;
    }

    public int getNumDoors()
    {
        return this.numDoors;
    }

    public String getTypeOfRoof()
    {
        return this.typeOfRoof;
    }

    public String getTypeOfWall()
    {
        return this.typeOfWall;
    }

    public void setNumWindows(int numWindows)
    {
        this.numWindows = numWindows;
    }

    public void setNumDoors(int numDoors)
    {
        this.numDoors = numDoors;
    }

    public void setTypeOfRoof(String typeOfRoof)
    {
        this.typeOfRoof = typeOfRoof;
    }

    public void setTypeOfWall(String typeOfWall)
    {
        this.typeOfWall = typeOfWall;
    }
}
