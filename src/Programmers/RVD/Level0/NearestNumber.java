package Programmers.RVD.Level0;

import java.util.Arrays;

public class NearestNumber {
    public int solution(int[] array, int n){

        Arrays.sort(array);

        for(int i=1; i<array.length; i++){
            if (Math.abs(n - array[0]) > Math.abs(n - array[i])){
                array[0] = array[i];
            }
        }

        return array[0];
    }
}
