package day2;

import java.io.File;
import java.util.Scanner;

public class part2 {
    private static final String FILE = "AOC-2024/day2/info.dat"; 

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File(FILE));
            int safe = 0;

            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split("\\s+");

                int[] levels = new int[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    levels[i] = Integer.parseInt(parts[i]);
                }

                if (isSafe(levels) || oneOff(levels)) {
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

            if (diff < 1 || diff > 3) { 
                return false;
            }
            if (levels[i] <= levels[i - 1]) { 
                increasing = false;
            }
            if (levels[i] >= levels[i - 1]) { 
                decreasing = false;
            }
        }
        return increasing || decreasing;
    }

    private static boolean oneOff(int[] levels) {
        for (int i = 0; i < levels.length; i++) {
            int[] newLevels = new int[levels.length - 1];
            int nextInd = 0; 
            for (int j = 0; j < levels.length; j++) {
                if (j != i) {
                    newLevels[nextInd] = levels[j];
                    nextInd++;
                }
            }
            if (isSafe(newLevels)) {
                return true;
            }
        }
        return false;
    }
}
