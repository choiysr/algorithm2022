package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2606 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodes = Integer.parseInt(br.readLine());
        boolean[][] connected = new boolean[nodes+1][nodes+1];
        boolean[] visited = new boolean[nodes+1];
        int count = 0;

        int couple = Integer.parseInt(br.readLine());

        for (int i = 0; i < couple; i++) {
            String[] input = br.readLine().split(" ");
            connected[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = true;
            connected[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            for(int i = 1; i < nodes+1; i++) {
                if(!visited[i] && connected[curr][i]) {
                    queue.add(i);
                    visited[i] = true;
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}
