public class SumAndAverage
{
    public static void main(String[] args)
    {
        int[] values = {1, 2, 3};

        int sum = 0;

        for (int i = 0; i < values.length; i++)
        {
            sum = sum + values[i];
        }

        double average = sum / (double) values.length;

        System.out.println("The sum is: " + sum);
        System.out.println("The average is: "+ average);
    }
}
