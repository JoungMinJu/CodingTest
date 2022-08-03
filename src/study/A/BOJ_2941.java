package study.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
    static int index;
    static int next;
    static char first = ' ';
    static char second = ' ';
    static char third = ' ';
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        index = 0;
        while(index < input.length()){
            answer ++;
            next = index +1;
            first = input.charAt(index);
            switch (first){
                case 'c':
                    if(next >= input.length()){
                        index ++;
                        break;
                    }
                    second = input.charAt(next);
                    if (second == '=' || second == '-')
                        index = next+1;
                    else
                        index ++;
                    break;
                case 'l':
                case 'n':
                    if(next >= input.length()){
                        index ++;
                        break;
                    }
                    second = input.charAt(next);
                    if(second == 'j')
                        index = next+1;
                    else index ++;
                    break;
                case 's':
                case 'z':
                    if(next >= input.length()){
                        index ++;
                        break;
                    }
                    second = input.charAt(next);
                    if(second == '=')
                        index = next+1;
                    else index ++;
                    break;
                case 'd':
                    if(next >= input.length()){
                        index ++;
                        break;
                    }
                    second = input.charAt(next);
                    if(second == '-')
                        index = next+1;
                    else if(second == 'z'){
                        if(next+1 >= input.length()){
                            index++;
                            break;
                        }
                        third = input.charAt(next+1);
                        if(third == '=')
                            index = next +2;
                        else index ++;
                        break;
                    }
                    else index ++;
                    break;
                default:
                    index++;
                    break;
            }
        }
        System.out.println(answer);
    }

}
