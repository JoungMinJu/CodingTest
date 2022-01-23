package Programmers.Level1.DivArr;

import java.util.Arrays;

public class DivArr_adv {
    public int[] divisible(int[] array, int divisor){
        return Arrays.stream(array).filter(factor -> factor%divisor == 0).toArray();
    }
}
