package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2588 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int firstNo = Integer.parseInt(br.readLine());
        String secondNo = br.readLine();

        for(int i = 2; i >= 0; i--) {
            System.out.println(firstNo * Integer.parseInt(String.valueOf(secondNo.charAt(i))));
        }
        System.out.println(firstNo * Integer.parseInt(secondNo));

    }

}
