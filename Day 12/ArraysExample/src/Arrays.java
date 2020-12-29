public class Arrays
{
    public static void main(String[] args)
    {
        int[] numbers = new int[10];

        numbers[0] = 10;
        numbers[1] = 15;
        numbers[2] = 20;
        numbers[3] = 25;

        int[] numbers2 = {10, 15, 20, 25};

        for (int i = 0; i < numbers.length; i++)
        {
            System.out.println(numbers2[i]);
        }

        System.out.println();

        for (int val : numbers2)
        {
            System.out.println(val);
        }
    }
}
