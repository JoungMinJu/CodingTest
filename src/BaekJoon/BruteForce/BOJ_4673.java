package BaekJoon.BruteForce;

public class BOJ_4673 {
    public static void main(String[] args) {
        boolean[] ans = new boolean[10001];
        for(int i=1;i<=10000;i++){
            int n = bf(i);
            if(n<=10000) ans[n] = true;
        }
        for(int i=1;i<ans.length;i++){
            if(!ans[i]) System.out.println(i);
        }
    }

    private static int bf(int i){
        int tp = i;
        while(i>0){
            tp += i%10;
            i/=10;
        }
        return tp;
    }
}
