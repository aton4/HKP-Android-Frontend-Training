package com.example.loops;

public class Loops
{
    public static void main(String[] args)
    {
        // the while loop

        int x = 0; // loop control variable;

        while (x < 5)
        {
            System.out.println("Hello World!");
            x++;
        }

        System.out.println("");

        // to do-while loop

        int y = 0;

        do {
            System.out.println("Hello World!");
            y++;

        } while ( y < 5); // post-test loop

        System.out.println("");

        // the for loop

        for (int i = 0; i < 5; i++) // pre-test loop
        {
            System.out.println("hello World!");
        }
    }
}
