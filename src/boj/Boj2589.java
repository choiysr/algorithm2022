package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * dfs로 최장거리를 찾고, bfs로 최단거리를 찾는 것 > 실패(메모리 초과) 
 */
public class Boj2589 {

    private static String[][] map;
    private static boolean[][] visited;

    private static int maxDistance = 0;
    private static int minDistance = Integer.MAX_VALUE;
    private static int[] directionX = {0, -1, 1, 0};
    private static int[] directionY = {-1, 0, 0, 1};

    private static Node maxDistanceStart = new Node(0,0);
    private static Node maxDistanceEnd = new Node(0,0);

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");
        int row = Integer.parseInt(mapSize[0]);
        int column = Integer.parseInt(mapSize[1]);

        map = new String[row][column];
        visited = new boolean[row][column];
        resetArray();

        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < column; j++) {
                map[i][j] = line[j];
            }
        }

        // 최장경로 시작점 확인
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j].equals("L") && !visited[i][j]) {
                    int prevMaxDistance = maxDistance;
                    Node currNode = new Node(i,j,0);
                    dfs(currNode);
                    if(prevMaxDistance != maxDistance) {
                        maxDistanceStart = currNode;
                    }
                    resetArray(); // 방문 체크 초기화
                }
            }
        }

        bfs(maxDistanceStart,maxDistanceEnd);
        System.out.println(minDistance);

    }


    private static void dfs(Node node) {

        visited[node.x][node.y] = true;
        if(maxDistance < node.distance) {
            maxDistance = node.distance;
            maxDistanceEnd = new Node(node.x, node.y, node.distance);
        }

        for (int i = 0; i < 4; i++) {
            Node nextNode = new Node(node.x+directionX[i], node.y+directionY[i], node.distance+1);
            if(isReachable(nextNode)) {
                dfs(nextNode);
            }
        }
    }

    private static void bfs(Node startNode, Node endNode) {

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(startNode);

        while(!nodes.isEmpty()) {
            Node curr = nodes.poll();
            visited[curr.x][curr.y] = true;
            if(curr.x == endNode.x && curr.y == endNode.y) {
                minDistance = Math.min(curr.distance, minDistance);
            }

            for(int i = 0;i < 4; i ++) {
                Node nextNode = new Node(curr.x+directionX[i], curr.y+directionY[i],curr.distance+1);
                if(isReachable(nextNode)) {
                    nodes.add(nextNode);
                }
            }
        }

    }

    private static boolean isReachable(Node node) {
        return !(node.x < 0 || node.x >= visited.length || node.y < 0 || node.y >= visited[node.x].length || visited[node.x][node.y] || map[node.x][node.y].equals("W"));
    }

    private static void resetArray() {
        for(boolean line[]:visited) {
            Arrays.fill(line, false);
        }
    }

    public static class Node {

        int x,y,distance;

        public Node(int x, int y) {
            this(x,y,0);
        }

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }





}
