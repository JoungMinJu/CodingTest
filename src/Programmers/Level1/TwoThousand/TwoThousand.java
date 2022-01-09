package Programmers.Level1.TwoThousand;

public class TwoThousand {
    public String solution(int a, int b) {
        String[] week = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        //2월 29일이 있는 2016년
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        int temp = 0;
        // 8일 금요일 1일 금요일 == -해서 7이면 같은 요일


        for(int i = 1; i<= a; i++){
            if(i == a){
                temp +=b;
                continue;
            }
            temp+=days[i];
        }

        return week[(temp-1)%7];
}}
