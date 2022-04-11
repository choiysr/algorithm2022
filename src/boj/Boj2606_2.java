package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2606_2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList();

        int computer = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[computer + 1][computer + 1];
        boolean[] check = new boolean[computer + 1];
        int cnt = 0;

        for (int i = 0; i < line; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            map[x][y] = true;
            map[y][x] = true;
        }

        q.add(1);
        check[1] = true;

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int i = 0; i < map.length; i++) {

                if (map[node][i] && !check[i]) {
                    q.add(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
