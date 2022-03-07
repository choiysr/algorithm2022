package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj1316 {

    public static void main(String[] args) throws IOException {

        System.out.println((int) 'a'); // 97
        System.out.println((int) 'z'); // 122

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int groupWordCount = 0;

        int n = Integer.parseInt(br.readLine());
        String[] strArray = new String[n];

        for (int i = 0; i < n; i++) {
            strArray[i] = br.readLine();
        }

        for (String str : strArray) {
            int[] charIndexCount = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int charIdx = (int) str.charAt(i) - 97;
                if (i + 1 - charIndexCount[charIdx] < 1 || charIndexCount[charIdx] == 0) {
                    charIndexCount[charIdx] = i + 1;
                } else {
                    break;
                }
            }
        }


    }

}
