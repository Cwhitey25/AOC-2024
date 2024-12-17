package day1;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class part1 {
    private static final String FILE = "AOC-2024/day1/info.dat";
    private static final int SIZE = 1000;

    public static void main(String[] args)
    {
        try
        {
            int[] left = new int[SIZE];
            int[] right = new int[SIZE];

            int count = 0;
            Scanner input = new Scanner(new File(FILE));
            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] parts = line.split("\\s+");

                //splits up left and right side of file into arrays
                left[count] = Integer.parseInt(parts[0]);
                right[count] = Integer.parseInt(parts[1]);

                count++;
            }
            input.close();

            //orders arrays in ascending order
            Arrays.sort(left);
            Arrays.sort(right);

            int distance = 0;
            for (int i = 0; i < SIZE; i++)
            {
                distance += Math.abs(left[i] - right[i]);
            }

            System.out.println(distance);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
