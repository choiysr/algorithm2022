package boj;

import java.util.*;

public class Boj3052 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < 10; i++) {
            set.add(new Scanner(System.in).nextInt()%42);
        }
        System.out.println(set.size());
    }
}
