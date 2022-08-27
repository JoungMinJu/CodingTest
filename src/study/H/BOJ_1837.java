package study.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_1837 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger p = new BigInteger(st.nextToken());
        BigInteger k = new BigInteger(st.nextToken());

        BigInteger i = new BigInteger("1");

        while(true){
            if(i.compareTo(k) == 1 || i.compareTo(i)==0){
                System.out.println("GOOD");
                break;
            }
            i = i.add(BigInteger.ONE);

            if(p.remainder(i).compareTo(BigInteger.ZERO) == 0 && i.compareTo(k) == -1){
                System.out.println("BAD " + i);
                break;
            }
        }

    }
}
