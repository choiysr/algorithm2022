package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 메모리초과.
 * 모든 경우의 수를 뽑아내고 -> 실제로 불을 껐다 켜봄
 */

public class Boj14936 {

    private static int FLOOR, TIME_LIMIT;
    private static int[] times = new int[4];
    private static Set<String> buttonStep = new HashSet<>();

    // m 초 이하의 동작은 그 이후에 다른 동작을 할 수 있는 경우가 있더라도 case로 따진다.
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        FLOOR = Integer.parseInt(input[0]);
        TIME_LIMIT = Integer.parseInt(input[1]);

        int allBtnTime = FLOOR;
        int evenBtnTime = FLOOR / 2;
        int oddBtnTime = allBtnTime - evenBtnTime;
        int threeKBtnTime = FLOOR % 3 == 0 ? FLOOR / 3 : FLOOR / 3 + 1;

        times[0] = allBtnTime;
        times[1] = evenBtnTime;
        times[2] = oddBtnTime;
        times[3] = threeKBtnTime;

        makeCase("", 0);
        Set<List<Boolean>> buttonStateSet = new HashSet<>();

        for (String str : buttonStep) {
            buttonStateSet.add(makeButtonState(str));
        }

        System.out.println(buttonStateSet.size());


    }

    private static void makeCase(String caseNoStr, int time) {

        for (int i = 0; i < 4; i++) {
            if (time + times[i] > TIME_LIMIT) {
                buttonStep.add(caseNoStr);
            } else {
                buttonStep.add(caseNoStr);
                makeCase(caseNoStr + String.valueOf(i + 1), time + times[i]);
            }
        }

    }

    private static List<Boolean> makeButtonState(String step) {

        List<Boolean> buttons = new ArrayList<Boolean>(Arrays.asList(new Boolean[FLOOR]));
        Collections.fill(buttons, Boolean.TRUE);

        for (int i = 0; i < step.length(); i++) {
            buttons = pushButtons(Integer.parseInt(step.charAt(i) + ""), buttons);
        }

        return buttons;
    }

    private static List<Boolean> pushButtons(int caseNo, List<Boolean> buttons) {

        switch (caseNo) {
            case 1:
                for (int i = 0; i < buttons.size(); i++) {
                    buttons.set(i, !buttons.get(i));
                }
                break;
            case 2:
                for (int i = 0; i < buttons.size(); i++) {
                    if ((i + 1) % 2 == 0) buttons.set(i, !buttons.get(i));
                }
                break;
            case 3:
                for (int i = 0; i < buttons.size(); i++) {
                    if ((i + 1) % 2 != 0) buttons.set(i, !buttons.get(i));
                }
                break;
            case 4:
                for (int i = 0; i < buttons.size(); i++) {
                    if (1 == i + 1 || (i % 3 == 0)) buttons.set(i, !buttons.get(i));
                }
                break;
        }

        return buttons;

    }


}
