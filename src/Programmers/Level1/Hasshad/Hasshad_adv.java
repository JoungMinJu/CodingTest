package Programmers.Level1.Hasshad;

public class Hasshad_adv {
    public boolean solution(int num){
        String[] tmp = String.valueOf(num).split("");
        int sum = 0;

        for(String s: tmp){
            sum += Integer.parseInt(s);
        }
        return num%sum==0;
    }
}
