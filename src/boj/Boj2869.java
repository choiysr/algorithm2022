package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[0]);
        int v = Integer.parseInt(input[0]);
        int answer;

        if(v==a) {
            answer = 1; 
        } else if (v%(a-b)==0) {
            answer = v/(a-b)-b;
        } else {
            answer = v/(a-b)+1;
        }

        System.out.println(answer);
    }
}
