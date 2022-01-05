package Programmers.Level1.Phonecatmon;
import java.util.Arrays;
import java.util.stream.Collectors;
//stream.collect()는 데이터의 중간 처리 후 마지막에 원하는 형태로 변환해주는 역할을 한다.
// 사실 걍 이해 안됨 ㅠ



public class PhoneCatMon_adv {
    public int solution(int[] nums){
        // boxed()는 int, long, double을 Integer, Long, Double 요소로 박싱해서 Stream을 생성한다.
        // collect()는 stream의 최종 연산, 매개변수로 Collector를 필요로 한다.
        // collectingAndThen 은 Collecting 진행한 후 그 결과로 메서드를 하나 더 호출할 수 있게 해준다.

        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.collectingAndThen
                        (Collectors.toSet(), phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)));
    }

}
