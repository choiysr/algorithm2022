package boj;

import java.util.Scanner;

/**
 * collection을 사용하지 않고 풀기
 */
public class Boj2164_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 2, answer = n;

        // 2의 제곱수인 경우 자기 자신을 출력하고 종료.
        if(Math.log(n)/Math.log(2) % 1 == 0) {
            System.out.println(answer);
            return;
        }

        while (n > 2) {
            int square = (int) Math.pow(2, i);
            if (square > n) {
                answer = (n - (square / 2)) * 2;
                break;
            }
            i++;
        }

        System.out.println(answer);

    }

}

