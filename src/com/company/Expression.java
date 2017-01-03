package com.company;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public interface Expression {

    Expression replaceVariables(SubstitutionSet s);
}
