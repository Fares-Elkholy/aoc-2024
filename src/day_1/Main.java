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

        try (BufferedReader br = new BufferedReader(new FileReader("src/input.txt"))) {
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
        // Print the lists to verify


        leftSide.sort(Comparator.naturalOrder());
        rightSide.sort(Comparator.naturalOrder());


        // Part 1
        int sum = 0;
        for (int i = 0; i < leftSide.size(); i++) {
            sum += Math.abs(leftSide.get(i) - rightSide.get(i));
        }
        System.out.println("The total distance between the lists is:  " + sum);
    }

}
