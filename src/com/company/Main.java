package com.company;

import java.util.*;

public class Main {

    private void forwardChaining() {
        List<Integer> count = new ArrayList<Integer>();
        Map<Clause, Boolean> inferred = new HashMap<Clause, Boolean>();
        List<Unifiable> agenda = new ArrayList<Unifiable>();
        Constant goal = new Constant();

        while(!agenda.isEmpty()) {
            Unifiable p = agenda.get(0);
            agenda.remove(0);

            for (Clause i : inferred.keySet()) {
                if (!inferred.get(i)) {
                    inferred.replace(i, true);

                    if (i.getClause().indexOf(p) != -1) {
                        Clause newClause = i.resolve(p);

                        if (newClause.getClause().size() == 1) {
                            if ((Unifiable)newClause.getClause().get(0) == goal) {
                                System.out.println("Succes!");
                            } else {
                                inferred.put(newClause, false);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//        Constant socrate = new Constant("socrate");
//        Variable X = new Variable("X");
//        Constant om = new Constant("om");
//        Constant muritor =  new Constant("muritor");

        Vector<Unifiable> expressions = new Vector<>();

//        expressions.add(new Predicate(om, socrate));
//        expressions.add(new Predicate(om, X));
//        expressions.add(new Predicate(muritor, X));
//
//
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

        expressions.add(new Predicate(american,true, X));
        expressions.add(new Predicate(weapon,true, Y));
        expressions.add(new Predicate(sells,true, X, Y, Z));
        expressions.add(new Predicate(hostile,true, Z));
        expressions.add(new Predicate(criminal,true, X));
        expressions.add(new Predicate(nono,true, m1));
        expressions.add(new Predicate(missile,true, m1));
        expressions.add(new Predicate(missile,true, X));
        expressions.add(new Predicate(owns,true, nono, X));
        expressions.add(new Predicate(sells,true, west, X, nono));
        expressions.add(new Predicate(missile,true, X));
        expressions.add(new Predicate(weapon,true, X));
        expressions.add(new Predicate(enemy,true, X, america));
        expressions.add(new Predicate(hostile,true, X));
        expressions.add(new Predicate(american,true, west));
        expressions.add(new Predicate(enemy,true, nono, america));


        Unifiable goal =  new Predicate(criminal,true, west);

        Iterator i =  expressions.iterator();
        SubstitutionSet s;
        System.out.println("Goal = " + goal);
        while(i.hasNext()){
            Unifiable next = (Unifiable) i.next();


            s = next.unify(goal, new SubstitutionSet());
            if(s != null ){
                System.out.println(goal.replaceVariables(s));
            }else{
                System.out.println("False");
            }
        }
    }
}
