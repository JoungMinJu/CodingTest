package BaekJoon.Plus;
import java.util.Scanner;

public class BOJ_5534{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String origin = sc.nextLine();
        String[] old = new String[n];
        for (int i = 0; i < n; i++) {
            old[i] =sc.nextLine();
        }

        int answer = 0;
        int[] index = new int[origin.length()];

        for(String s : old){
            int j = origin.length() - 1;
            for(int i=s.length()-1;i>=0;i--){
                if(origin.charAt(j) == s.charAt(i)) {
                    index[j] = i;
                    j --;
                    if(j<0) break;
                }
            }
            int gap = index[1]-index[0];
            for(int i=1; i<index.length-1;i++){
                if(gap != (index[i+1] - index[i])){
                    break;
                }
                answer++;

            }

        }
        System.out.println(answer);
    }


}
