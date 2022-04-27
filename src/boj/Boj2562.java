package boj;

import java.util.Scanner;

public class Boj2562 {

    public static void main(String[] args) {
        int[] arr = new int[10];
        int idx = 0;
        int value = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if(value < arr[i]) {
                value = arr[i];
                idx = i;
            }
        }
        System.out.println(value);
        System.out.println(idx);
    }
}
