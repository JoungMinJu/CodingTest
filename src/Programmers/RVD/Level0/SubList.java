package Programmers.RVD.Level0;

import java.util.*;

public class SubList {

    public int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
