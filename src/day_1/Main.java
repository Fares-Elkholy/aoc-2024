package day_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> leftSide = new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();

        // parse input
        try (BufferedReader br = new BufferedReader(new FileReader("src/day_1/input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    leftSide.add(Integer.parseInt(parts[0]));
                    rightSide.add(Integer.parseInt(parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // sort the lists
        leftSide.sort(Comparator.naturalOrder());
        rightSide.sort(Comparator.naturalOrder());


        // Part 1
        int sum = 0;
        for (int i = 0; i < leftSide.size(); i++) {
            sum += Math.abs(leftSide.get(i) - rightSide.get(i));
        }
        System.out.println("The total distance between the lists is:  " + sum);

        int score = 0;
        int index, curr, left, occurences;

        // Part 2
        for (int i = 0; i < leftSide.size(); i++) {
            left = leftSide.get(i);
            curr = left;
            index = rightSide.indexOf(left);

            if (index != -1) {
                occurences = 0;
                while (curr == left) {
                    occurences++;
                    index++;
                    curr = rightSide.get(index);
                }
                score += occurences * left;
            }
        }

        System.out.println("The similarity score is: " + score);
    }

}
