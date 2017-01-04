package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        SOCRATE
         */
//        Constant socrate = new Constant("socrate");
//        Variable X = new Variable("X");
//        Constant om = new Constant("om");
//        Constant muritor = new Constant("muritor");
//
//
//        ArrayList<Clause> clauses = new ArrayList<>();
//
//        Predicate firstPredicate = new Predicate(om, true, socrate);
//        List<Predicate> firstClause = new ArrayList<>();
//        firstClause.add(firstPredicate);
//
//        clauses.add(new Clause(firstClause));
//
//        Predicate secondPredicate = new Predicate(om, false, X);
//        Predicate thirdPredicate = new Predicate(muritor, true, X);
//        List<Predicate> secondClause = new ArrayList<>();
//        secondClause.add(secondPredicate);
//        secondClause.add(thirdPredicate);
//
//        clauses.add(new Clause(secondClause));
//
//        Predicate goal = new Predicate(muritor, true, socrate);
//
//        ForwardChaining.forwardChaining(clauses, goal);

        /*
        SMART/SKATE JOE
         */
        Constant joe = new Constant("joe");
        Variable X = new Variable("X");
        Variable Y = new Variable("Y");
        Variable Z = new Variable("Z");
        Constant smart = new Constant("smart");
        Constant likesHockey = new Constant("likesHockey");
        Constant canadian = new Constant("canadian");
        Constant skates = new Constant("skates");
        Constant rpi = new Constant("rpi");

        Vector<Unifiable> expressions = new Vector<>();

        ArrayList<Clause> clauses = new ArrayList<>();

        List<Predicate> clauseList = new ArrayList<>();
        clauseList.add(new Predicate(smart, true, X));
        clauseList.add(new Predicate(likesHockey, false, X));
        clauseList.add(new Predicate(rpi, false, X));
        clauses.add(new Clause(clauseList));

//        clauseList = new ArrayList<>();
//        clauseList.add(new Predicate(canadian, true, Y));
//        clauseList.add(new Predicate(likesHockey, false, Y));
//        clauses.add(new Clause(clauseList));

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


//        Constant american = new Constant("american");
//        Constant weapon = new Constant("weapon");
//        Constant sells = new Constant("sells");
//        Constant hostile = new Constant("hostile");
//        Constant criminal = new Constant("criminal");
//        Constant missile = new Constant("missile");
//        Constant owns = new Constant("owns");
//        Constant enemy = new Constant("enemy");
//
//        Constant nono = new Constant("nono");
//        Constant m1 = new Constant("m1");
//        Constant west = new Constant("west");
//        Constant america = new Constant("america");
//
//        Variable X = new Variable("X");
//        Variable Y = new Variable("Y");
//        Variable Z = new Variable("Z");
//
//        expressions.add(new Predicate(american,true, X));
//        expressions.add(new Predicate(weapon,true, Y));
//        expressions.add(new Predicate(sells,true, X, Y, Z));
//        expressions.add(new Predicate(hostile,true, Z));
//        expressions.add(new Predicate(criminal,true, X));
//        expressions.add(new Predicate(nono,true, m1));
//        expressions.add(new Predicate(missile,true, m1));
//        expressions.add(new Predicate(missile,true, X));
//        expressions.add(new Predicate(owns,true, nono, X));
//        expressions.add(new Predicate(sells,true, west, X, nono));
//        expressions.add(new Predicate(missile,true, X));
//        expressions.add(new Predicate(weapon,true, X));
//        expressions.add(new Predicate(enemy,true, X, america));
//        expressions.add(new Predicate(hostile,true, X));
//        expressions.add(new Predicate(american,true, west));
//        expressions.add(new Predicate(enemy,true, nono, america));
//
//
//        Unifiable goal =  new Predicate(criminal,true, west);
//
//        Iterator i =  expressions.iterator();
//        SubstitutionSet s;
//        System.out.println("Goal = " + goal);
//        while(i.hasNext()){
//            Unifiable next = (Unifiable) i.next();
//
//
//            s = next.unify(goal, new SubstitutionSet());
//            if(s != null ){
//                System.out.println(goal.replaceVariables(s));
//            }else{
//                System.out.println("False");
//            }
//        }
//    }
    }
}
