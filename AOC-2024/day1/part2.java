package day1;

import java.io.File;
import java.util.Scanner;

public class part2 {
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

                left[count] = Integer.parseInt(parts[0]);
                right[count] = Integer.parseInt(parts[1]);

                count++;
            }
            input.close();

            int score = 0;

            //iterates through left array
            for (int i = 0; i < SIZE; i++)
            {
                int total = 0;
                //checks for copies of elements from left array in right array
                for (int j = 0; j < SIZE; j++)
                {
                    if (left[i] == right[j])
                    {
                        total++;
                    }
                }
                score += left[i] * total;
            }
            System.out.println(score);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
