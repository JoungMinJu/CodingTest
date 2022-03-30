package Algorithm_Two.CH2;

public class Factorial {
    public static void main(String[] args) {
        int answer;
        int f=10;
        answer =factorial(f);
        System.out.println(f+"의 계승 = "+answer);
    }

    private static int factorial(int f) {
        if(f==0) return 1;
        else return f*factorial(f-1);
    }
}
