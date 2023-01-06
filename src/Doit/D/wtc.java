package Doit.D;

import ssafy.D2.A;

import java.util.ArrayList;
import java.util.List;

public class wtc {
    public static void main(String[] args) {
        List<Coach> coaches = List.of(new Coach("가"), new Coach("나"), new Coach("다"));
        List<Coach> copy  = new ArrayList<>(coaches);
        System.out.println(copy);
    }

    public static class Coach{
        String name;

        public Coach(String name) {
            this.name = name;
        }
    }
}
