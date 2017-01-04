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

    //Changed == with .equals, so it will work for
    //two different instances (our case)
    @Override
    public SubstitutionSet unify(Unifiable exp,
                                 SubstitutionSet s)
    {
        if (exp instanceof Constant && this.equals(exp))
            return new SubstitutionSet(s);
        if (exp instanceof Variable)
            return exp.unify(this, s);
        return null;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Constant && this.name.equals(((Constant)o).name);
    }
}
