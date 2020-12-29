package com.example.methods;

public class Methods
{
    public static void main(String[] args)
    {
        // A void method is one that simply performs a task and then terminates

//        System.out.println("This is a vbid method!");

        // A value-returning method not only performs a task,
        // but also sends a value back to the code that called it

//        int number = Integer.parseInt("700");

        printAverage(20, 30);

        String fullName = fullName("John", "Rambo");
        System.out.println(fullName);

        int value = 20;

        if (isValid(value))
        {
            System.out.println("The value is in range!");
        }
        else
        {
            System.out.println("The value is not in range!");
        }
    }

    /**
     * This method prints the average of two numbers
     * @param val1
     * @param val2
     */
    public static void printAverage(int val1, int val2)
    {
        double average = (val1 + val2) / 2.0;
        System.out.println("Average: " + average);
    }

    /**
     * This method returns the average of two numbers
     * @param val1
     * @param val2
     * @return
     */
    public static double getAverage(int val1, int val2)
    {
        double average = (val1 + val2) / 2.0;
        return average;
    }

    /**
     * This method returns a string containing the name and surname
     * @param name
     * @param surname
     * @return
     */
    public static String fullName(String name, String surname)
    {
        String fullName = name + " " + surname;
        return fullName;
    }

    /**
     * This method returns a Boolean of whether the number is valid
     * @param number
     * @return
     */
    public static Boolean isValid(int number)
    {
        return (number >= 1 && number <= 100);
    }

}
