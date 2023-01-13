package Programmers.RVD.Level0;

public class PushString {
    // A를 밀어서 B를 만들 수 있으면, 몇 번 밀어서 만들 수 있는지 return
    // 못만들면 -1 return;

    public int solution(String A, String B){
        int answer = 0;
        String result = A;

        for (int i = 0; i < A.length(); i++){
            if (result.equals(B)){
                return answer;
            }
            String a = result.substring(result.length() - 1); // 맨 끝 글자
            result = a + result.substring(0, result.length() -1 );
            answer ++;
        }

        return -1; // 한 번도 equals 안되면 -1 return 하기
    }
}
