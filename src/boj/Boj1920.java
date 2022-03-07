package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Boj1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Set<String> set = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());
        br.readLine();
        Arrays.stream(br.readLine().split(" ")).map(i->set.contains(i) ? "1":"0").forEach(System.out::println);

    }

}
