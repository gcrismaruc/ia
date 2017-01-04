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

    Clause resolve(Unifiable unifiable) {
        SubstitutionSet s;
        Clause newClause = new Clause();

        for (Unifiable p : clause) {
            s = p.unify(unifiable, new SubstitutionSet());

            if (s != null) {
                for (Predicate pToReplace : clause) {
                    if (pToReplace.getTerm(0) == ((Predicate)unifiable).getTerm(0)) {
                        System.out.println("Resolved");
                    } else {
                        newClause.getClause().add((Predicate) pToReplace.replaceVariables(s));
                    }
                }

                break;
            }
        }

        return newClause;
    }

}
