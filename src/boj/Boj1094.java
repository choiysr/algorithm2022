package boj;

import java.util.Scanner;

public class Boj1094 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String binary = Integer.toBinaryString(sc.nextInt());
        int count = 0;

        for(int i = 0 ; i < binary.length(); i++) {
            if(binary.charAt(i) == '1') count++;
        }

        System.out.println(count);

    }

}
