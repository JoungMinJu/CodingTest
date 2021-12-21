package Programmers.Level1.Lotto;
import java.util.HashMap;
import java.util.Map;

public class LottoAdvanced {
    public int [] solution(int[] lottos, int[] win_nums){
        Map<Integer, Boolean> map =new HashMap<Integer, Boolean>();
        int zero = 0;

        for(int lotto : lottos){
            if(lotto==0){
                zero++;
                continue;
            }
            //0이 아니면 HashMap에 넣는다.
            map.put(lotto, true);
        }
        int same = 0 ;
        for(int winNum : win_nums){
            if(map.containsKey(winNum)) same++;
        }
        //grade를 계산하는 규칙
        //switch 안쓸 수 있음.
        int maxRank = 7 - (same + zero);
        int minRank = 7 -same;
        if(maxRank>6) maxRank = 6;
        if(minRank<6) minRank = 6;

        return new int[] {maxRank, minRank};
    }
}
