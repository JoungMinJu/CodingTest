package Programmers.RVD.Level0;

public class IToJFindK {
    // i 부터 j 까지 숫자에서 k가 등장하는 횟수 세기

    public int solution(int i, int j, int k){
        String str = "";
        for(int num = i; num <= j; num++){
            str += num+"";
        }

        return str.length() - str.replace(k+"", "").length();
    }
}
