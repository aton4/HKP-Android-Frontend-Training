package com.example.classes;

public class DriverClass
{
    public static void main(String[] args)
    {
        House house = new House(10,2, "Tiles", "Brick");

        house.setNumDoors(3);
        house.setTypeOfWall("Plaster");

        System.out.println("House: ");
        System.out.println("Num of Windows: " + house.getNumWindows());
        System.out.println("Num of Doors: " + house.getNumDoors());
        System.out.println("Type of Roof: " + house.getTypeOfRoof());
        System.out.println("Type of Wall: " + house.getTypeOfWall());
    }
}
