package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj2309 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> babies = new ArrayList<>();
        int sum = 0;

        for(int i = 0; i < 9; i++) {
            babies.add(sc.nextInt());
            sum += babies.get(i);
        }

         Loop1: for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if(sum - babies.get(i) - babies.get(j) == 100) {
                    babies.remove(j);
                    babies.remove(i);
                    break Loop1;
                }
            }
        }

        babies.stream().sorted().forEach(System.out::println);

    }

}
