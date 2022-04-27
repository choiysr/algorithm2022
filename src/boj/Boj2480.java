package boj;

import java.util.Scanner;

public class Boj2480 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] count = new int[7];
        int max = 0; 

        for (int i = 0; i < 3; i++) {
            count[sc.nextInt()]++;
        }

        for (int i = 1; i <= 6; i++) {
            if(count[i] == 3) {
                System.out.println(10000+i*1000);
                return;
            }
            if(count[i] == 2) {
                System.out.println(1000+i*100);
                return;
            }
            if(count[i]!=0) {
                max = Math.max(i, max);
            }
        }

        System.out.println(max*100);

    }

}
