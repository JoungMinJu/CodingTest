package Programmers.RVD.Level0;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ranking {
    // [영어, 수학] 점수로 주어지는데, 이 평균을 ! 구해서
    // 해당 사람의 등수 구하기

    public int[] solution(int[][] score){
        List<Integer> scores = new ArrayList<>();
        int[] answer = new int[score.length];

        for(int[] s : score){
            scores.add(s[0] + s[1]);
        }

        scores.sort(Comparator.reverseOrder());

        for(int i=0; i<score.length; i++){
            answer[i] = scores.indexOf(score[i][0] + score[i][1]) + 1;
        }

        // 어차피 indexOf하면 제일 작은 index가 나오기 때문에 중복 처리(ex, 3등 3등) 신경 안써도됨
        return answer;
    }
}
