package BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// O(N제곱 알고리즘)이 된다..응

public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> s = new HashSet<>();
        for(int i=0;i<n;i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        // Hash set에 넣고 set을 정렬하기
        for(int i=0;i<n;i++){
            s.add(arr.get(i));
        }
        // hashset 정렬
        ArrayList<Integer> lst = new ArrayList<>(s);
        Collections.sort(lst);

        Map<Integer, Integer> indexList = new HashMap<>();

        int rank = 0;
        for(int i=0;i<lst.size();i++){
            indexList.put(lst.get(i), rank);
            rank++;
        }

        for(int i=0;i<n;i++){
            ans.add(indexList.get(arr.get(i)));
        }
        for (Integer an : ans) {
            System.out.print(an+" ");
        }

    }
}
