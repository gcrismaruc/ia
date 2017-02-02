package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public class Clause {

    public List<Predicate> getClause() {
        return clause;
    }

    public void setClause(List<Predicate> clause) {
        this.clause = clause;
    }

    private List<Predicate> clause;

    public Clause(){
        clause = new ArrayList<Predicate>();
    }

    public Clause(List<Predicate> s){
        this.clause = s;
    }

    Clause resolve(Clause monoClause) {
        SubstitutionSet s;
        Clause newClause = new Clause();

        Predicate knownPredicate = monoClause.getClause().get(0);

        for (Unifiable p : clause) {
            s = p.unify(knownPredicate, new SubstitutionSet());

            if (s != null) {
                for (Predicate pToReplace : clause) {
                    if (pToReplace.getTerm(0).equals((knownPredicate.getTerm(0)))
                    && (pToReplace.isNegative() != knownPredicate.isNegative())) {
                        System.out.println("Resolved");
                    } else {
                        newClause.getClause().add(pToReplace.replaceVariables(s));
                    }
                }

                break;
            }
        }

        return newClause;
    }

}
