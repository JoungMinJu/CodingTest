package Programmers.Level1.DescString;

public class DescString_adv {
    String res  = "";
    public int reverseInt(int n){
        // chars는 String의 문자들의 stream을 만들어준다.
        Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) +res);
        return Integer.parseInt(res);
    }
}
