package Programmers.Level1.Runner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Runner {
    // 효율성 통과 못함

    public String solution(String[] participant, String[] completion){
        String answer="";
        ArrayList<String> part = new ArrayList<>(Arrays.asList(participant));
        ArrayList<String> comp = new ArrayList<>(Arrays.asList(completion));

        for(String p : participant){
            for(String c : comp){
                if( p.equals(c)){
                    part.remove(p);
                    comp.remove(c);
                    break;
                }
            }
        }
        for(String p : part){
            answer +=p;
        }
        return answer;
    }
}
