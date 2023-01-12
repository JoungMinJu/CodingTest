package Programmers.RVD.Level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrderIndex {
    // 몇 번째 우선순위인지 출력
    public int[] solution(int[] e) {
        return Arrays.stream(e)
                .map(i
                        -> Arrays.stream(e)
                        .boxed()
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList())
                        .indexOf(i) + 1)
                .toArray();
    }
}
