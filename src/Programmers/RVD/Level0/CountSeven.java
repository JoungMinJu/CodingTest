package Programmers.RVD.Level0;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CountSeven {
    // 7의 개수 세기
    //  ex [7, 11, 17, 77] => 4
    public int solution(int[] array){
        return (int) Arrays.stream(
                Arrays.stream(array)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining())
                        .split("")
        )
                .filter(s -> s.equals("7"))
                .count();
    }
}
