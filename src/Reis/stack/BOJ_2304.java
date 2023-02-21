package Reis.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2304 {
    static class Pillar implements Comparable<Pillar> {
        int pos, height;

        public Pillar(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }

        @Override
        public int compareTo(Pillar o) {
            return this.pos - o.pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<Pillar> pillars = new ArrayList<>();
        Stack<Pillar> leftStack = new Stack<>();
        Stack<Pillar> rightStack = new Stack<>();
        long answer = 0;

        int N = Integer.parseInt(br.readLine()); // 기둥의 개수

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pillars.add(new Pillar(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(pillars);

        for (Pillar pillar : pillars) {
            if (leftStack.isEmpty())
                leftStack.push(pillar);
            else if (leftStack.peek().height < pillar.height) {
                leftStack.push(pillar);
            }
        }

        for (int i = pillars.size() -1; i>=0; i--) {
            Pillar pillar = pillars.get(i);
            if(rightStack.isEmpty())
                rightStack.push(pillar);
            else if (rightStack.peek().height < pillar.height) {
                rightStack.push(pillar);
            }
        }

        answer += ((rightStack.peek().pos+1) - (leftStack.peek().pos)) * rightStack.peek().height;

        Pillar leftBefore = leftStack.pop();
        while (!leftStack.isEmpty()) {
            answer += (leftBefore.pos - leftStack.peek().pos) * leftStack.peek().height;
            leftBefore = leftStack.pop();
        }

        Pillar rightBefore = rightStack.pop();
        while (!rightStack.isEmpty()) {
            answer += (rightStack.peek().pos - rightBefore.pos) * rightStack.peek().height;
            rightBefore = rightStack.pop();
        }

        System.out.println(answer);
    }
}
