package boj;

import java.util.Scanner;

public class Boj24389 {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int original = sc.nextInt();

        String orgStr = Integer.toBinaryString(original);
        String revStr = Integer.toBinaryString(~original + 1);
        int count = 0;

        while(orgStr.length() != revStr.length()) {
            orgStr = "0" + orgStr;
        }

        for(int i = 0 ; i < orgStr.length(); i++) {
            if(orgStr.charAt(i) != revStr.charAt(i)) count++;
        }

        System.out.println(count);

    }

}
