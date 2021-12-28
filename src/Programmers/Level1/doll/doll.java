package Programmers.Level1.doll;
import java.util.Stack;

public class doll {
    public int solution(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int top = -1;
        int input = -1;
        int len = board.length;
        for(int i :moves){
            for(int j=0; j<len;j++){
                input = board[j][i-1];
                if(input!=0){
                    if(!stack.empty()){
                        top = stack.peek();
                        if(input!=top){
                            stack.push(input);}
                        else{
                            while(input == top){
                                answer +=1;
                                stack.pop();
                                top = stack.peek();}
                            answer +=1;}}
                    else{
                        stack.push(board[j][i-1]);}
                    board[j][i-1] = 0;
                    break;
                }
            }}
        return answer;
    }
}
