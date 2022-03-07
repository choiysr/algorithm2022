package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String input = br.readLine();
            Stack<Integer> checkStack = new Stack<>();
            boolean isWrong = false;

            for (int j = 0; j < input.length(); j++) {
                int target = input.charAt(j);
                if (target == '(') {
                    checkStack.push(target);
                } else {
                    if (checkStack.isEmpty()) {
                        isWrong = true;
                        break;
                    }
                    checkStack.pop();
                }
            }

            if (isWrong || !checkStack.isEmpty()) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }

        }

    }
}
