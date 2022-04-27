package boj;

import java.util.Scanner;

public class Boj2525 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt() + sc.nextInt();
        
        h = (h+m/60)%24; 
        m %= 60;

        System.out.printf("%d %d",h,m);

    }
}
