package day3;

import java.io.File;
import java.util.Scanner;
import java.util.regex.*;

public class part2 {
    private static final String FILE = "AOC-2024/day3/info.dat";

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File(FILE));

            int sum = 0;
            boolean canMul = true; 

            //regex syntax to scan through "do", "don't" and "mul(x,y)"
            Pattern pattern = Pattern.compile("do\\(\\)|don't\\(\\)|mul\\((\\d{1,3}),(\\d{1,3})\\)");

            while (input.hasNextLine()) {
                String line = input.nextLine();

                //used to search the file for the above pattern
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String match = matcher.group();
                    //enable multiplying
                    if (match.equals("do()")) 
                    {
                        canMul = true;
                    }
                    //disable multiplying
                    else if (match.equals("don't()")) 
                    {
                        canMul = false;
                    } 
                    //standard case
                    else if (canMul && match.startsWith("mul")) {
                        int x = Integer.parseInt(matcher.group(1));
                        int y = Integer.parseInt(matcher.group(2));
                        sum += x * y;
                    }
                }
            }
            input.close();

            System.out.println(sum);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
