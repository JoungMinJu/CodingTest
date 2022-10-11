package SSW;

import java.util.*;

class CharacterType {
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        String[] types = {"RT", "CF", "JM", "AN"};
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for(int i=0; i<survey.length; i++){
            int score = choices[i];
            char key = ' ';
            int nextScore = 0;
            if(score < 4){
                key = survey[i].charAt(0);
                nextScore = map.get(key) + (4-score);
            }
            else if(score >4){
                key = survey[i].charAt(1);
                nextScore=  map.get(key) + (score-4);
            }
            else continue;
            map.put(key, nextScore);
        }

        for(int i=0; i<types.length; i++){
            char firstType = types[i].charAt(0);
            char secondType = types[i].charAt(1);
            if(map.get(firstType) < map.get(secondType)){
                sb.append(secondType);
            }
            else if(map.get(firstType) > map.get(secondType)){
                sb.append(firstType);
            }
            else{
                sb.append(firstType<secondType ? firstType : secondType);
            }
        }

        return sb.toString();

    }
}