package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2580 {

    private static int[][] board = new int[9][9];
    private static List<Node> blankNodes = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                int number = Integer.parseInt(input[j]);
                board[i][j] = number;
                if (number == 0) blankNodes.add(new Node(i, j));
            }
        }

        for (Node node : blankNodes) {
            // 해당 위치에 가능한 숫자 리스트를 세팅 
            setAvailableNumbers(node);
        }
        
        for(int i = blankNodes.size()-1; i>=0; i--) {
            Node node = blankNodes.get(i);
            if(node.availableNumbers.size() == 0) {
                board[node.x][node.y] = node.availableNumbers.get(0);
                blankNodes.remove(i);
            }
        }

        dfs(0, blankNodes.get(0), 0);
        
    }

    private static void setAvailableNumbers(Node node) {

        boolean[] checkRow = new boolean[10];
        boolean[] checkCol = new boolean[10];
        boolean[] checkBox = new boolean[10];

        for (int i = 0; i < 9; i++) {
            checkRow[board[node.x][i]] = true;  // 가로확인(x고정 y변동)
            checkCol[board[i][node.y]] = true;  // 세로확인(x변동 y고정)
            checkBox[board[node.boxStartX + (i / 3)][node.boxStartY + (i - (i / 3) - (i / 3) * 2)]] = true; // 칸확인 
        }

        for (int i = 1; i <= 9; i++) {
            if ((!checkRow[i] && !checkCol[i] && !checkBox[i])) {
                node.availableNumbers.add(i);
            }
        }

    }

    private static void dfs(int blankNodeIdx, Node node, int availableNumberIdx) {
        
        board[node.x][node.y] = node.availableNumbers.get(availableNumberIdx);
        boolean isRightNumber = isRight(node);

        if (isRightNumber && blankNodeIdx == blankNodes.size() - 1) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0 ; i < 9; i ++) {
                sb.setLength(0);
                for(int j = 0 ; j < 9 ; j++) {
                    sb.append(board[i][j]+" ");
                }
                System.out.println(sb.toString().trim());
            }
            System.exit(0);
        }

        if (isRightNumber) {
            // 다음 노드 탐색
            int nextBlankNodeIdx = blankNodeIdx + 1;
            dfs(nextBlankNodeIdx, blankNodes.get(nextBlankNodeIdx), 0);
            if(node.availableNumbers.size() > availableNumberIdx + 1) {
                dfs(blankNodeIdx, node, availableNumberIdx + 1);
            } else {
                board[node.x][node.y] = 0;
            }
        } else {
            // 안되는 경우 그 다음 가능한 숫자로 탐색. 근데 다음숫자가 없으면 이전노드로 돌아가야함 
            board[node.x][node.y] = 0;
            if (node.availableNumbers.size() > availableNumberIdx + 1) {
                dfs(blankNodeIdx, node, availableNumberIdx + 1);
            }
        }

    }

    private static boolean isRight(Node node) {

        boolean[] checkRow = new boolean[10];
        boolean[] checkCol = new boolean[10];
        boolean[] checkBox = new boolean[10];

        for (int i = 0; i < 9; i++) {
            if (!checkRow[board[node.x][i]] || board[node.x][i] == 0) {
                checkRow[board[node.x][i]] = true;  // 가로확인(x고정 y변동) 
            } else {
                return false;
            }

            if (!checkCol[board[i][node.y]] || board[i][node.y] == 0) {
                checkCol[board[i][node.y]] = true;  // 세로확인(x변동 y고정)
            } else {
                return false;
            }

            if (!checkBox[board[node.boxStartX + (i / 3)][node.boxStartY + (i - (i / 3) - (i / 3) * 2)]]
             || board[node.boxStartX + (i / 3)][node.boxStartY + (i - (i / 3) - (i / 3) * 2)] == 0 ) {
                checkBox[board[node.boxStartX + (i / 3)][node.boxStartY + (i - (i / 3) - (i / 3) * 2)]] = true; // 칸확인 
            } else {
                return false;
            }
        }

        return true;

    }

    private static class Node {

        int x, y;
        List<Integer> availableNumbers = new ArrayList<>();
        int boxStartX, boxStartY;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

            if (x <= 2) {
                this.boxStartX = 0;
            } else if (x <= 5) {
                this.boxStartX = 3;
            } else {
                this.boxStartX = 6;
            }

            if (y <= 2) {
                this.boxStartY = 0;
            } else if (y <= 5) {
                this.boxStartY = 3;
            } else {
                this.boxStartY = 6;
            }
        }

    }


}
