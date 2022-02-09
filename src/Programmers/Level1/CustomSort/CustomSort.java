package Programmers.Level1.CustomSort;

import java.util.ArrayList;
import java.util.Collections;

public class CustomSort {
    static class St implements Comparable<St>{
        String line;
        int index;

        public St(String line, int index) {
            this.line = line;
            this.index = index;
        }

        @Override
        public int compareTo(St o) {
            if(this.line.charAt(index) == o.line.charAt(index)) return this.line.compareTo(o.line);
            return this.line.charAt(index) - o.line.charAt(index);

        }
    }

    public String[] solution(String[] strings, int n){
        ArrayList<St> lst = new ArrayList<>();
        for(int i=0;i<strings.length;i++){
            lst.add(new St(strings[i],n));
        }
        Collections.sort(lst);
        String[] answer = new String[strings.length];
        for(int i=0;i<strings.length;i++){
            answer[i] = lst.get(i).line;
        }
        return answer;
    }


}
