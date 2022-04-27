package boj;

import java.util.Scanner;

public class Boj2577 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = 1;
        for (int i = 0; i < 3; i++) {
            num *= sc.nextInt();
        }

        String numStr = String.valueOf(num);
        
        int[] index = new int[10];
        for (int i = 0; i < numStr.length(); i++) {
            index[numStr.charAt(i) - '0']++;
        }

        for (int i = 0; i < index.length; i++) {
            System.out.println(index[i]);
        }


    }

}
