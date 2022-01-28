package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Boj1978 {

    private static List<Integer> primeNumbers;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNo = Integer.parseInt(br.readLine());
        int[] numbers = new int[inputNo];
        int count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < inputNo ; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        initPrimeNumbers();

        for(int i : numbers) {
            count += primeNumbers.contains(i) ? 1 : 0;
        }

        System.out.println(count);

    }

    private static void initPrimeNumbers() {
        int[] numArr = IntStream.range(0,1001).toArray();
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
