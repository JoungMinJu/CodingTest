package Programmers.Level1.Runner;
import java.util.*;

public class Runner_adv_two {
    //list 그대로 쓰는 풀이
    public String solution(String[] participant, String[] completion){
    Arrays.sort(participant);
    Arrays.sort(completion);
    //i를 밖에 선언하네. 딱 한 명이 완주 못했어서 가능한
    int i;
    for(i=0; i<completion.length;i++){
        if(!participant[i].equals(completion[i])){
            return participant[i];
        }
    }
    //맨 마지막이 정답일 경우
    return participant[i];
    }
}
