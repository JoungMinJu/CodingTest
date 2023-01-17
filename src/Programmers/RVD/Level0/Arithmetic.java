package Programmers.RVD.Level0;

public class Arithmetic {
    // 주어진 수열은 등차 아니면 등비 수열!
    // 그 다음에 나올 숫자 return 하기

    public int solution(int[] common){
        int answer = 0;
        int x = common[1] - common[0];
        int y = common[2] - common[1];

        if( x == y){
            return common[common.length - 1] + y;
        } else {
            return common[common.length - 1] * common[2] / common[1];
        }
    }
}
