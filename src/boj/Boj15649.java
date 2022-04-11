package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj15649 {

    private static int N,M;
    private static List<String> list = new ArrayList<>();
    private static int[] combi;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        combi = new int[M];

        makeArray(1,0);

        /**
         * depth는 ++되는 값. (N 까지 증가 할 수 있음)
         * idx는 결과물로 나올 string의 자릿수(최대 M-1)
         */
        System.out.println(list);

    }

    private static void makeArray(int depth, int idx) {

        System.out.println(combi);

        // 나를 포함 하던지 / 안하던지
        combi[idx] = depth;
        if(idx+1 <= M-1) {
            makeArray(depth+1, idx+1);
        }
        makeArray(depth+1, idx);


    }

}
