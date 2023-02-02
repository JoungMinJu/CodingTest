package java8.B;

import java.util.function.Function;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {

        // 1. 익명 클래스 사용해서 구현해보기
        Function<String, Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        };
        // 1-2. 사용하는 방법??
        Integer number = toInt.apply("100");
        System.out.println(number);

        // 2. 람다 익스프레션으로 만들기 -1
        Function<String, Integer> toInt2 = (String s)  -> {
                return Integer.parseInt(s);
            };

        // 3. 더 간단한 람다 익스프레션
        // Function 타입에 선언해놨기 때문에 어떤 타입을 받아서 어떤 타입을 return하는지 다 알고 있다.
        Function<String, Integer> toInt3 = (s)  -> Integer.parseInt(s);

        // 4. 파라미터가 하나면 괄호도 지워도 된다.
        Function<String, Integer> toInt4 = s -> Integer.parseInt(s);

        // 4-1
        Integer apply = toInt4.apply("100");
        System.out.println(apply);

        // 아이덴티티에 대해 알아보기
        final Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(999));

        // 아이덴티티 직접 만들어서 사용해보기
        final Function<Integer, Integer> identity2 = t -> t;
        System.out.println(identity2.apply(112));
    }
}
