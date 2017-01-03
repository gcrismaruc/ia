package com.company;

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
    }

    public Clause(List<Predicate> s){
        this.clause = s;
    }

    Clause resolve(Unifiable unifiable) {
        SubstitutionSet s;

        for (Unifiable p : clause) {
            s = p.unify(unifiable, new SubstitutionSet());

            if (s != null) {
                for (Unifiable pToReplace : clause) {
                    pToReplace.replaceVariables(s);
                }

                break;
            }
        }

        clause.remove(unifiable);

        return new Clause(clause);
    }

}
