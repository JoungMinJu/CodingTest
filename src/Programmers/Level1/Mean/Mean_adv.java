package Programmers.Level1.Mean;
import java.util.Arrays;

public class Mean_adv {
    public int getMean(int[] array){
        return (int) Arrays.stream(array).average().orElse(0);
    }
}
