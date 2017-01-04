package com.company;

import java.util.*;

public class Main {
    public static  void socrate() {
        Constant socrate = new Constant("socrate");
        Variable X = new Variable("X");
        Constant om = new Constant("om");
        Constant muritor = new Constant("muritor");

        ArrayList<Clause> clauses = new ArrayList<>();

        List<Predicate> clauseList = new ArrayList<>();
        clauseList.add(new Predicate(om, true, socrate));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(om, false, X));
        clauseList.add(new Predicate(muritor, true, X));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(muritor, false, socrate));
        Clause goal = new Clause(clauseList);

        ForwardChaining.forwardChaining(clauses, goal);
    }

    public static void joe() {
        Constant joe = new Constant("joe");
        Variable X = new Variable("X");
        Variable Y = new Variable("Y");
        Variable Z = new Variable("Z");
        Constant smart = new Constant("smart");
        Constant likesHockey = new Constant("likesHockey");
        Constant canadian = new Constant("canadian");
        Constant skates = new Constant("skates");
        Constant rpi = new Constant("rpi");

        ArrayList<Clause> clauses = new ArrayList<>();

        List<Predicate> clauseList = new ArrayList<>();
        clauseList.add(new Predicate(smart, true, X));
        clauseList.add(new Predicate(likesHockey, false, X));
        clauseList.add(new Predicate(rpi, false, X));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(canadian, true, Y));
        clauseList.add(new Predicate(likesHockey, false, Y));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(skates, true, Z));
        clauseList.add(new Predicate(likesHockey, false, Z));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(smart, false, joe));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(skates, false, joe));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(rpi, false, joe));
        Clause goal = new Clause(clauseList);

        ForwardChaining.forwardChaining(clauses, goal);
    }

    public static void west() {
        Constant american = new Constant("american");
        Constant weapon = new Constant("weapon");
        Constant sells = new Constant("sells");
        Constant hostile = new Constant("hostile");
        Constant criminal = new Constant("criminal");
        Constant missile = new Constant("missile");
        Constant owns = new Constant("owns");
        Constant enemy = new Constant("enemy");

        Constant nono = new Constant("nono");
        Constant m1 = new Constant("m1");
        Constant west = new Constant("west");
        Constant america = new Constant("america");

        Variable X = new Variable("X");
        Variable Y = new Variable("Y");
        Variable Z = new Variable("Z");

        ArrayList<Clause> clauses = new ArrayList<>();

        List<Predicate> clauseList = new ArrayList<>();
        clauseList.add(new Predicate(american, true, X));
        clauseList.add(new Predicate(weapon, true, Y));
        clauseList.add(new Predicate(sells, true, X, Y, Z));
        clauseList.add(new Predicate(hostile, true, Z));
        clauseList.add(new Predicate(criminal, false, X));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(missile, true, m1));
        clauseList.add(new Predicate(owns, true, nono, X));
        clauseList.add(new Predicate(sells, false, west, X, nono));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(missile, true, X));
        clauseList.add(new Predicate(weapon, false,  X));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(enemy, true, X, america));
        clauseList.add(new Predicate(hostile, true, X));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(owns, false, nono, m1));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(missile, false, m1));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(american, false, west));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(enemy, false, nono, america));
        clauses.add(new Clause(clauseList));

        clauseList = new ArrayList<>();
        clauseList.add(new Predicate(criminal, false, west));
        Clause goal = new Clause(clauseList);

        ForwardChaining.forwardChaining(clauses, goal);
    }
    public static void main(String[] args) {
        System.out.println("Socrate");
        socrate();
        System.out.println("Joe");
        joe();
        System.out.println("West");
        west();
    }
}
