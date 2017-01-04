package com.company;

import java.util.*;

public class Main {
    public static void resolve(String filepath) {
        Parser parser = new Parser();
        List<Clause> clauses = parser.readFile(filepath);

        Clause goal = clauses.get(clauses.size() - 1);
        clauses.remove(clauses.size() - 1);

        ForwardChaining.forwardChaining(clauses, goal);
    }

    public static void main(String[] args) {
        System.out.println("Socrate");
        resolve("data/socrate.facts");
        System.out.println("Joe");
        resolve("data/joe.facts");
        System.out.println("West");
        resolve("data/west.facts");
    }
}
