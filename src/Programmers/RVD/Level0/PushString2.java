package Programmers.RVD.Level0;

public class PushString2 {
    // A를 밀어서 B를 만들 수 있으면, 몇 번 밀어서 만들 수 있는지 return
    // 못만들면 -1 return;

    public int solution(String A, String B){
        String tempB = B.repeat(2);
        return tempB.indexOf(A);
    }
}
