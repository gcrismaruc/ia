package com.company;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public class Constant implements Unifiable {

    private String name;
    private static int nextId = 1;
    private int id;

    public Constant(){
        this.id = nextId++;
    }

    public Constant(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString(){

        return this.name != null ? name:"constant_"+id;
    }

    @Override
    public Expression replaceVariables(SubstitutionSet s)
    {
        return  this;
    }

    @Override
    public SubstitutionSet unify(Unifiable exp,
                                 SubstitutionSet s)
    {
        if (this == exp)
            return new SubstitutionSet(s);
        if (exp instanceof Variable)
            return exp.unify(this, s);
        return null;
    }
}
