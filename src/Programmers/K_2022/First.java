package Programmers.K_2022;

import java.util.HashMap;

public class First {
    public static class Person{
        HashMap<String, Integer> type;
        public Person() {
            type  = new HashMap<>();
            type.put("R",0);
            type.put("T",0);
            type.put("C",0);
            type.put("F",0);
            type.put("J",0);
            type.put("M",0);
            type.put("A",0);
            type.put("N",0);
        }
    }
    public static String solution(String[] survey, int[] choices){
        Person p = new Person();
        for(int i=0;i<survey.length;i++){
            int choice = choices[i];
            if(choice==4) continue;
            if(choice < 4){
                String t = ""+survey[i].charAt(0);
                int now_score = p.type.get(t);
                p.type.replace(t, now_score + (4-choice));
            }
            else{
                String t = ""+survey[i].charAt(1);
                int now_score = p.type.get(t);
                p.type.replace(t, now_score + (choice-4));
            }
        }
        String answer = "";
        String type_sort[] = {"R", "T", "C", "F", "J","M", "A", "N"};
        for(int i=0;i<type_sort.length-1;i+=2){
            String first = type_sort[i];
            String second = type_sort[i+1];
            if(p.type.get(first) >= p.type.get(second)) answer+=first;
            else answer+=second;
        }
        return answer;
    }

    public static void main(String[] args) {
        String survey[] = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        System.out.println(solution(survey, choices));
    }
}
