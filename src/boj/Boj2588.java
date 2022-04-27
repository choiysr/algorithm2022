package boj;


import java.util.Scanner;

public class Boj2588 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstNo = Integer.parseInt(sc.nextLine());
        String secondNo = sc.nextLine();

        for(int i = 2; i >= 0; i--) {
            System.out.println(firstNo * Integer.parseInt(String.valueOf(secondNo.charAt(i))));
        }
        System.out.println(firstNo * Integer.parseInt(secondNo));

    }

}
