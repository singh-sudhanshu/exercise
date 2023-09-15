package io.java.exercise.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class League {

    private final String id;
    private final String name;
    private final Integer score;

    public League(String id, String name, Integer score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }
}

class app {
    public static void main(String[] args) {
        League league1 = new League("one", "summer", 60);
        League league2 = new League("two", "winter", 80);
        League league3 = new League("three", "fall", 40);

        List<League> leagues = new ArrayList<>();
        leagues.add(league1);
        leagues.add(league2);
        leagues.add(league3);

        leagues.sort(Comparator.comparing(League::getScore));
        System.out.println(leagues);
    }
}
