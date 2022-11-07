package Programmers.SKT_2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Fourth {

    public static Map<Character, Integer> scaleIndexMap = new HashMap<>() {
        {
            put('C', 1);
            put('D',3);
            put('E',5);
            put('F', 6);
            put('G',8);
            put('A',10);
            put('B', 12);
        }
    };

    public static Map<Integer, Character> indexScaleMap = new HashMap<>(){
        {
            put(1,'C');
            put(3, 'D');
            put(5, 'E');
            put(6, 'F');
            put(8, 'G');
            put(10, 'A');
            put(12,'B');
        }
    };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 음계 개수
        String[] input = new String[n];
        for(int i=0; i<n; i++) {
            input[i] = br.readLine();
        }
        int m = Integer.parseInt(br.readLine()); // 올릴지 내릴지 개수

        char nowScale;
        int nowIndex;
        int nextIndex;
        int step;
        for (String s : input) {
            sb.setLength(0);
            nowScale = s.charAt(0);
            nowIndex = scaleIndexMap.get(nowScale);
            nextIndex = nowIndex + m;
            if(s.length() == 3){
                nextIndex += 1;
            }
            if(nextIndex < 0){
                nextIndex = nextIndex + 25;
            }
            step =  (nextIndex % 25) / 13;
            nextIndex %= 13;
            indexScaleMap.get(nextIndex);
            if(!indexScaleMap.containsKey(nextIndex)){
                Character scale = indexScaleMap.get(nextIndex - 1);
                sb.append(scale)
                        .append(step)
                        .append("#");
            }
            else{
                sb.append(indexScaleMap.get(nextIndex))
                        .append(step);
            }
            System.out.println(sb.toString());
        }
    }
    }

