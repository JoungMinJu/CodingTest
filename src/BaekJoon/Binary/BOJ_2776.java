package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2776 {
    static int t;
    static int n;
    static int m;
    static int[] n_list;
    static int[] m_list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int j=0;j<t;j++){
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            n_list = new int[n];
            for(int i=0;i<n;i++){
                n_list[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            m_list= new int[m];
            st= new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                m_list[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(n_list);

            for(int i=0;i<m;i++){
                System.out.println(binarySearch(m_list[i]));
            }}
    }

    private static int binarySearch(int i) {
        int start = 0;
        int end = n_list.length-1;
        while(start<=end){
            int mid =(start+end)/2;
            if(n_list[mid] < i) start = mid+1;
            else if(n_list[mid] > i) end = mid -1;
            else if(n_list[mid] ==i) return 1;
        }
        return 0;
    }
}
