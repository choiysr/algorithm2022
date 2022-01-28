package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182 {

    private static int n,s;
    private static int count = 0;
    private static int[] numArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numArr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        checkArr(0,0);
        if(s == 0) count --; // cheeckArr()의 여러 경우의 수 중 '모든 인덱스를 더하지 않는 경우'가 존재하기 때문
                             // 아무것도 더하지 않아 0인 경우는 count하면 안되니까 빼줌.
        System.out.println(count);

    }

    private static void checkArr(int sum, int idx) {

        // 종료조건이 n 인게 나중에 보기 헷갈릴 수 있을 것 같음. (왜 중간에 멈추지 않는가?)
        // 배열을 끝까지 탐색했으나 그 과정에서 더했던 수도 있고 더하지 않았던 수도 있다는 사실을 생각하기.
        if(idx == n) {
            if(sum == s) {
                count++;
            }
            return;
        }

        // 재귀 이해 포인트는 현재 수를 더하거나, 더하지 않거나. "두가지"로 분기하는 것.
        // 쭉 더하다가 더하지 않는 경우도 있을 것이고, 더하지 않다가 더했다가 더하지 않았다가.. 할 수도 있겠지
        checkArr(numArr[idx]+sum, idx+1);
        checkArr(sum,idx+1);

    }

}
