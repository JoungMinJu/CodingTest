package SSW;

import java.util.*;

class intMate {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> answerList = new ArrayList<>();
        String answer = "";

        for(int i=0; i<10; i++){
            map.put(i, null);
        }

        for(int i=0; i<10; i++){
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(countChar(X, i));
            tmpList.add(countChar(Y, i));
            map.put(i, tmpList);
        }

        for(int i=0; i<10; i++){
            int xCount = map.get(i).get(0);
            int yCount = map.get(i).get(1);
            if(xCount == 0 || yCount ==0) continue;
            int time = xCount >= yCount ? yCount : xCount;
            for(int j=0; j<time; j++){
                answerList.add(i);
            }
        }


        Collections.sort(answerList, Collections.reverseOrder());

        if(answerList.size() <= 0){
            answer = "-1";
        }
        else {
            for(int i=0; i<answerList.size(); i++){
                sb.append(answerList.get(i));
            }
            answer = sb.toString();
            if(answer.charAt(0) == '0') answer = "0";
        }

        return answer;
    }

    public int countChar(String str, int i){
        return str.length() - str.replace(String.valueOf(i),"").length();
    }
}