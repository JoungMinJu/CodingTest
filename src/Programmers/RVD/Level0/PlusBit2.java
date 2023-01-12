package Programmers.RVD.Level0;

public class PlusBit2 {
    public static void main(String[] args) {
        System.out.println(solution("1001", "1111"));
    }
    public static String solution(String bin1, String bin2){
        int answer = Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2);
        return Integer.toString(answer, 2);
    }
}
