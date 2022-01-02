package Programmers.Level1.MathTest;
import java.util.ArrayList;

public class MathTest_adv {
    //완전탐색
    public int[] solution(int[] answer){
        int[] a ={1,2,3,4,5};
        int[] b ={2,1,2,3,2,4,2,5};
        int[] c= {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];

        for(int i=0;i<answer.length;i++){
            if(answer[i] == a[i%a.length]){score[0]++;}
            if(answer[i] == b[i%b.length]){score[1]++;}
            if(answer[i] == c[i%c.length]){score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]){list.add(1);}
        if(maxScore == score[1]){list.add(2);}
        if(maxScore == score[2]){list.add(3);}
        //ArrayList.stream()
        // list의 요소들을 하나씩 순회하면서 Interger -> int 변환
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
