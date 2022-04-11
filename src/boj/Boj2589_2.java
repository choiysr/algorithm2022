package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj2589_2 {

    private static String[][] map;
    private static boolean[][] visited;
    
    private static int[] directionX = {0, -1, 1, 0};
    private static int[] directionY = {-1, 0, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");
        int row = Integer.parseInt(mapSize[0]);
        int column = Integer.parseInt(mapSize[1]);

        map = new String[row][column];

        for (int i = 0; i < row; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < column; j++) {
                map[i][j] = line[j];
            }
        }
        
        int minTime = 0;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j].equals("L")) {
                    visited = new boolean[row][column];
                    visited[i][j] = true;
                    int time = bfs(new Node(i,j,0));
                    minTime = Math.max(time, minTime);
                }
            }
        }
        System.out.println(minTime);

    }


    /**
     * bfs가 결국 최단거리를 찾는 알고리즘이기 때문에
     * bfs로 탐색을 수행하는 것 == 최단거리를 찾는 것.
     * 결국 모든 노드를 start로 어떤 도착지점까지를 탐색할때, 그 도착지점까지의 distance는 최소값(최단거리)이 나올 것이고
     * 모든 노드를 시작점으로 탐색했을때 그중에 최장거리(Math.max)를 찾으면 결국 '나올 수 있는 긴 거리중 가장 짧은 거리'가 될 것임. 
     */
    private static int bfs(Node startNode) {
        
        int maxDistance = 0;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(startNode);
        
        while(!nodes.isEmpty()) {
            Node currNode = nodes.poll();
            for(int i = 0;i < 4; i ++) {
                Node nextNode = new Node(currNode.x+directionX[i], currNode.y+directionY[i],currNode.distance+1);
                if(isReachable(nextNode)) {
                    nodes.add(nextNode);
                    /**
                     * 방문체크를 하는 시점이 중요. isReachable을 검사하기 전 현재노드를 true로 할 시 
                     * 이미 queue에 있는 노드를 push 할 수 있음. 
                     */
                    visited[nextNode.x][nextNode.y] = true;
                    System.out.println(nextNode.distance);
                    maxDistance = Math.max(maxDistance, nextNode.distance);
                }
            }
        }
        
        return maxDistance;
    }

    private static boolean isReachable(Node node) {
        return !(node.x < 0 || node.x >= visited.length || node.y < 0 || node.y >= visited[node.x].length || visited[node.x][node.y] || map[node.x][node.y].equals("W"));
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
