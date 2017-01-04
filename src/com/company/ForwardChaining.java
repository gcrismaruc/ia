package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 1/4/2017.
 */
public class ForwardChaining {
    public static void forwardChaining(List<Clause> clauses, Clause goal) {
        List<Clause> inferred = new ArrayList<>();
        List<Clause> agenda = new ArrayList<>();
        int clauseIndex;

        List<Clause> usedClauses;

        for (Clause c : clauses) {
            if (c.getClause().size() == 1) {
                agenda.add(c);
            } else {
                inferred.add(c);
            }
        }

        while (!agenda.isEmpty()) {
            Clause monoClause = agenda.get(0);
            agenda.remove(0);

            clauseIndex = 0;
            while (clauseIndex < inferred.size()) {
                Clause currentClause = inferred.get(clauseIndex);

                if (predicateIsInClause(currentClause, monoClause.getClause().get(0))) {
                    Clause newClause = currentClause.resolve(monoClause);

                    inferred.remove(currentClause);
                    if (newClause.getClause().size() == 1) {
                        if (newClause.getClause().get(0).isEqual(goal.getClause().get(0))) {
                            System.out.println("Succes!");
                        } else {
                            agenda.add(newClause);
                        }
                    } else {
                        inferred.add(newClause);
                    }
                }

                clauseIndex++;
            }
        }
    }

    static boolean predicateIsInClause(Clause clause, Predicate predicateToFind) {
        for (Predicate predicate : clause.getClause()) {
            if (predicate.getTerm(0).equals(predicateToFind.getTerm(0))) {
                return true;
            }
        }
        return false;
    }
}
