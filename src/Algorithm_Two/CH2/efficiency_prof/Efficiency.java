package Algorithm_Two.CH2.efficiency_prof;

public class Efficiency {
    public static void main(String[] args) {
        int comSqr;
        comSqr = ComputeSquare1(5);
        System.out.println(comSqr);

        int[] FREQ = {1,0,7,5,4};
        int[] CUME;
        CUME = ComputeCumulativeSum2(FREQ);

        System.out.println("배열 CUME:");
        for (int i : CUME) {
            System.out.print(i+"\t");
        }

        // 팩토리얼
        int answer;
        int f=10;
        answer = factorial(f);
        System.out.println(f+"의 계승 = "+answer);
    }

    public static int ComputeSquare1(int n){
        return n*n;
    }

    public static int[] ComputeCumulativeSum2(int[] FREQ){
        // 빈도들의 누계 ㄱㅖ산
        int n= FREQ.length;
        int[] CUME = new int[n];
        CUME[0] =FREQ[0];
        for(int i=0;i<n;i++){
            CUME[i] = CUME[i-1]+FREQ[i];
        }
        return CUME;
    }

    public static int factorial(int f){
        if(f==0) return 1;
        else return f*factorial(f-1);
    }
}
