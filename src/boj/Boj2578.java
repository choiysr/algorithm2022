package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj2578 {

    private static int[][] board = new int[5][5];
    private static int[][] target = new int[5][5];
    private static boolean[][] check = new boolean[5][5];
    private static Map<Integer, String> positionMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeBoard(br, board);
        makeBoard(br, target);

        br.close();

        int count = 1;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String position = positionMap.get(target[i][j]);
                check[position.charAt(0) - '0'][position.charAt(1) - '0'] = true;
                if (count > 10 && checkBingo()) {
                    System.out.println(count);
                    return;
                }
                count++;
            }
        }
        
    }

    private static void makeBoard(BufferedReader br, int[][] array) throws IOException {
        
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(input[j]);
                array[i][j] = number;
                if (array == board) {
                    positionMap.put(number, i + "" + j);
                }
            }
        }
        
    }

    private static boolean checkBingo() {

        int count = 0;

        boolean isRightDiagonalBingo = true;
        boolean isLeftDiagonalBingo = true;

        for (int i = 0; i < 5; i++) {

            boolean isColBingo = true;
            boolean isRowBingo = true;

            for (int j = 0; j < 5; j++) {
                // 가로체크 
                if (isRowBingo && !check[i][j]) {
                    isRowBingo = false;
                }
                // 세로체크
                if (isColBingo && !check[j][i]) {
                    isColBingo = false;
                }
            }

            if (isColBingo) count++;
            if (isRowBingo) count++;

            // 오른쪽 아래로 내려가는 대각선 체크 
            if (isRightDiagonalBingo && !check[i][i]) {
                isRightDiagonalBingo = false;
            }
            // 왼쪽 아래로 내려가는 대각선 체크
            if (isLeftDiagonalBingo && !check[4 - i][i]) {
                isLeftDiagonalBingo = false;
            }
        }

        if (isRightDiagonalBingo) count++;
        if (isLeftDiagonalBingo) count++;

        return count >= 3;

    }

}
