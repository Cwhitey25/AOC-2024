package day2;

import java.io.File;
import java.util.Scanner;

public class part1 {
    private static final String FILE = "AOC-2024/day2/info.dat"; 

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File(FILE));
            int safe = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split("\\s+");

                //puts the "levels" from each "report" into a new array
                int[] levels = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    levels[i] = Integer.parseInt(parts[i]);
                }

                //counts every line that matches restrictions
                if (isSafe(levels)) {
                    safe++;
                }
            }
            input.close();

            System.out.println(safe);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isSafe(int[] levels) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < levels.length; i++) {
            int diff = Math.abs(levels[i] - levels[i - 1]);

            //makes sure differences are more than 1 but not more than 3
            if (diff < 1 || diff > 3) { 
                return false;
            }
            //checks constant increase
            if (levels[i] <= levels[i - 1]) { 
                increasing = false;
            }
            //checks constant decrease
            if (levels[i] >= levels[i - 1]) { 
                decreasing = false;
            }
        }
        return increasing || decreasing; 
    }
}
