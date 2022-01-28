package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Boj1929 {

    private static List<Integer> primeNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        initPrimeNumbers();
        primeNumbers.stream().forEach(i->{
            if(i >= start && i <= end) {
                System.out.println(i);
            }
        });
    }

    private static void initPrimeNumbers() {

        int[] numArr = IntStream.range(0,1000001).toArray();
        numArr[1] = 0;
        for(int i : numArr) {
            if(i != 0 && i > 1) {
                int j = 2;
                while(i * j <= 1000) {
                    numArr[i*j] = 0;
                    j++;
                }
            }
        }
        primeNumbers = Arrays.stream(numArr).filter(i->i!=0).boxed().collect(Collectors.toList());
    }

}
