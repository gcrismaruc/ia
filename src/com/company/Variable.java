package com.company;

/**
 * Created by Gheorghe on 12/30/2016.
 */
public class Variable implements Unifiable {

    private String name;
    private static int nextId = 1;
    private int id;

    public Variable(){
        this.id = nextId++;
    }

    public Variable(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString(){

        return this.name != null ? name:"variable_"+id;
    }


    //Changed == with .equals, so it will work for
    //two different instances (our case)
    @Override
    public SubstitutionSet unify(Unifiable p,
                                 SubstitutionSet s)
    {
        if (p instanceof Variable && this.equals(p)) return s;
        if(s.isBound(this))
            return s.getBinding(this).unify(p, s);
        SubstitutionSet sNew = new SubstitutionSet(s);
        sNew.add(this, p);
        return sNew;
    }

    @Override
    public Expression replaceVariables(
            SubstitutionSet s)
    {
        if(s.isBound(this))
            return s.getBinding(this).replaceVariables(s);
        else
            return this;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Variable && this.name.equals(((Variable)o).name);
    }
}
