package java8.D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {

    public static void main(String[] args) {

        // 조건에 만족하는지 확인할 때 주로 사용한다.
        // 주어진 Integer가 양수인지 확인하는 것으로 예제를 들고 있음
        Predicate<Integer> isPositive = value -> value > 0;
        System.out.println(isPositive.test(1));
        System.out.println(isPositive.test(0));

        List<Integer> numbers = Arrays.asList(-1, 1, 5, 4, -2);
        List<Integer> positiveNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (isPositive.test(number))
                positiveNumbers.add(number);
        }
        System.out.println(positiveNumbers.toString());

        // 위에 것을 간결하게 만들기 위해서 메소드 만든다요
        System.out.println(filter(numbers, isPositive));

        Predicate<Integer> lessThanThree = value -> value < 3;
        System.out.println(filter(numbers, lessThanThree));

        // 직접 써도 된다.
        System.out.println(filter(numbers, i -> i == 5));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T input : list) {
            if (filter.test(input)) {
                result.add(input);
            }
        }
        return result;
    }
}
