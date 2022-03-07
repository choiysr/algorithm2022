package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Boj2161 {

    public static void main(String[] args) {

        Queue<Integer> cardPack = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        IntStream.range(1, n + 1).forEach(i -> cardPack.add(i));

        while (cardPack.size() != 1) {
            System.out.print(cardPack.poll() + " ");
            cardPack.add(cardPack.poll());
        }

        System.out.println(cardPack.poll());

    }
}
