package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10867_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Set<Integer> numSet = new HashSet<>();
        for(int i = 0 ; i < n; i++) {
            numSet.add(Integer.parseInt(input[i]));
        }
        List<Integer> numList = new ArrayList<>(numSet);
        Collections.sort(numList);
        StringBuilder sb = new StringBuilder();

        for(Integer number : numList) {
            sb.append(number+" ");
        }

        System.out.println(sb.toString().trim());




    }

}
