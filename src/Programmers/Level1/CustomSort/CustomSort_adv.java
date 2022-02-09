package Programmers.Level1.CustomSort;

import java.util.ArrayList;
import java.util.Collections;

public class CustomSort_adv {
    public String[] solution(String[] strings, int n){
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        // 미쳤구만
        for(int i=0;i<strings.length;i++){
            arr.add(""+strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for(int i = 0;i<arr.size();i++){
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}
