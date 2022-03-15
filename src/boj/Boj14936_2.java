package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj14936_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int floor = Integer.parseInt(input[0]);
        int timeLimit = Integer.parseInt(input[1]);
        int count = 0;

        /**
         * (1) 아무것도 안켜짐
         * (2) 다 켜짐
         * (3) 짝수만 켜짐
         * (4) 홀수만 켜짐
         * (5) 3k+1만 켜짐
         * (6) 3k+1만 꺼짐
         * (7) 3,5,9...만 켜짐
         * (8) 2,6,8...만 켜짐
         */
        int[][] caseMask = {{0,0,0,0}, {1,0,0,0}, {0,1,0,0}, {0,0,1,0}, {0,0,0,1}, {1,0,0,1}, {0,0,1,1}, {0,1,0,1}};
        int[] time = {floor, floor / 2, floor - (floor / 2), floor % 3 == 0 ? floor / 3 : floor / 3 + 1};


        switch (floor) {
            case 1:
                // 층수가 1일경우 case 1(전체),3(홀수),4(3K+1)이 중복됨. case 3,4 제거
                // '아무버튼도 누르지 않은 경우'와 case2(짝수)가 중복됨. case2 제거
                time[1]=timeLimit+1;
                time[2]=timeLimit+1;
                time[3]=timeLimit+1;
                break;
            case 2:
                // 층수가 2일경우 case3(홀수),4(3K+1)가 중복됨. case 4제거
                time[3]=timeLimit+1;
        }

        for(int i = 0 ; i < caseMask.length; i++) {
            int tmpTime = 0;
            for(int j = 0; j < caseMask[i].length; j++) {
                if(caseMask[i][j] == 1) tmpTime+=time[j];
            }
            if(tmpTime <= timeLimit) count++;
        }



        System.out.println(count);


    }
}
