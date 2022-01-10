package Programmers.Level1.MinRect;
import java.util.*;

public class MinRect_adv {
    //min max를 쓰는게 제일 중요하기
    public int solution(int[][] sizes){
        // reduce(초기값, 연산)
        int max = 0;
        int min = 0;
        for(int[] size : sizes){
            int paraMax = Math.max(size[0], size[1]);
            int paraMin = Math.max(size[0], size[1]);

            if(paraMax > max){
                max = paraMax;
            }
            if(paraMin > min){
                min = paraMin;
            }
        }
        return max*min;
    }
}
