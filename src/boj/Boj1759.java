package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Boj1759 {

    private static int L, C;
    private static String[] letters;
    private static Set<String> wordSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        letters = br.readLine().split(" ");
        Arrays.sort(letters);

        setWordSet(0, "");

        wordSet.stream().forEach(System.out::println);

    }

    private static void setWordSet(int idx, String word) {

        if (word.length() == L) {
            if (isValid(Arrays.stream(word.split("")).sorted().collect(Collectors.joining("")))) {
                wordSet.add(word);
            }
            return;
        }

        if (idx != C) {
            setWordSet(idx + 1, word + letters[idx]);
            setWordSet(idx + 1, word);
        }

    }

    private static boolean isValid(String word) {

        boolean contains = word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u");

        String regex = "([aeiou\\W]+)";
        String result = word.replaceAll(regex, "");

        return result.length() >=2 && contains;
    }

}
