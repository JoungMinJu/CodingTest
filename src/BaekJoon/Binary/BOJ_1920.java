package BaekJoon.Binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    static int n;
    static int[] nlist;
    static int m;
    static int[] mlist;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        nlist = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            nlist[i]=Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        mlist= new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            mlist[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nlist);


        for(int i=0;i<m;i++){
            System.out.println(binarySearch(mlist[i]));
        }
    }


    private static int binarySearch(int i) {
        int start =0;
        int end = nlist.length-1;
        while(start<=end){
            int mid= (start+end)/2;
            if(nlist[mid] < i) start = mid+1;
            else if(nlist[mid] > i) end = mid-1;
            else if(nlist[mid] ==i) return 1;
        }
        return 0;
    }
}
