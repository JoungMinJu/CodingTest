package Programmers.Level2;

import java.util.Arrays;

//https://school.programmers.co.kr/learn/courses/30/lessons/42885

public class lifeBoat {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer =0;
        int sum = 0;

        int minIdx =0;
        for (int maxIdx = people.length-1; maxIdx >= minIdx; maxIdx--) {
            if (people[minIdx] + people[maxIdx] <= limit) {
                answer ++;
                minIdx++;
            }
            else {
                answer++;
            }
        }
        return answer;
    }
}
