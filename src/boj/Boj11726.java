package boj;

import java.util.Scanner;

public class Boj11726 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= n; i++) {
            arr[i] = arr[i-1]+arr[i-2];
            if(arr[i] > 10007) arr[i] %= 10007;
        }

        System.out.println(arr[n]);

    }

}
