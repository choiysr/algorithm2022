package boj;


import java.util.Scanner;

public class Boj2164 {

    private static boolean[] check;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cards[i] = i;
        }

        check = new boolean[cards.length];      // 요소가 버려졌으면 true
        boolean flag = true;                    // 이전 요소가 남겨졌음 true, 버려졌음 false

        while(!isLast()) {
            for (int i = 1; i < cards.length; i++) {
                if (!check[i]) {
                    if (flag) {
                        check[i] = true;
                    }
                    flag = !flag;
                }
            }
        }

    }

    private static boolean isLast() {

        int count = 0;
        int lastNode = 0;
        for(int i = 1; i < check.length; i++) {
            if(!check[i]) {
                lastNode = i;
                count++;
            }
        }

        if(count==1) {
            System.out.println(lastNode);
            return true;
        }

        return false;

    }


}
