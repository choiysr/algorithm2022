package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Boj2605 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] seq = br.readLine().split(" ");
        List<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(Integer.parseInt(seq[i - 1]), i);
        }

        Collections.reverse(list);
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
