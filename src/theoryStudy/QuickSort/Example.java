package theoryStudy.QuickSort;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Example {

    public static List<Integer> quickSort(List<Integer> lst) {
        if (lst.size() <= 1) {
            return lst;
        }
        int pivot = lst.get(lst.size() / 2);

        List<Integer> lesserArr  = new LinkedList<>();
        List<Integer> equalArr = new LinkedList<>();
        List<Integer> greaterArr = new LinkedList<>();

        for (Integer num : lst) {
            if (num < pivot)
                lesserArr.add(num);
            else if (num > pivot)
                greaterArr.add(num);
            else
                equalArr.add(num);
        }

        return Stream.of(quickSort(lesserArr), equalArr, quickSort(greaterArr))
                .flatMap(Collection::stream)// 중첩 구조 한 단계 제거하기 위한 중간 연산
                .collect(Collectors.toList());
    }
}
