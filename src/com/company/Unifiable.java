package com.company;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public interface Unifiable extends Expression {

    SubstitutionSet unify(Unifiable exp, SubstitutionSet s);
}
