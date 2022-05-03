package Programmers.Level2;

public class StringCompressionTest {
    public static void main(String[] args) {
        String s="aabbccddeea";
        //2a2b2c2d2ea
        System.out.println(soulution(s));
    }

    // 한개씩 자르는 방법 시도

    private static String soulution(String s) {
        StringBuilder sb = new StringBuilder();
        int length  = s.length();
        char now;
        char next = 0;
        int count = 1;
        // 1개씩 잘라보기
        for(int i=0;i<length-1;i++){
            now = s.charAt(i);
            next = s.charAt(i+1);
            System.out.println("next = " + next);
            System.out.println("now = " + now);
            if(now == next){
                count ++;
            }
            else if(i!=0){
                if(count !=1){
                    sb.append(""+count);
                    count = 1;
                    sb.append(now);
                }
                else if(count ==1){
                 sb.append(now);}
            }
            // 마지막 남은거 있으면 넣어주기


            System.out.println("count = " + count);
            System.out.println(sb.toString());
            System.out.println();
            }
        sb.append(s.charAt(s.length()-1));

        return sb.toString();
    }
}
